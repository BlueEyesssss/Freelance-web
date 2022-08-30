-- Last modification date: 2022-07-20
CREATE database FreelanceManagement
GO
-- Remember to create Database named "FreelanceManagement"
USE FreelanceManagement
-- tables
-- Table: Contract

CREATE TABLE Contract (
    contractID int  NOT NULL IDENTITY,
    proposalID int  NOT NULL,
    paymentAmount decimal(8,2)  NOT NULL,
    startTime date  NOT NULL,
    endTime date  NOT NULL,
    CONSTRAINT Contract_pk PRIMARY KEY  (contractID)
);

-- Table: ExpectedDuration
CREATE TABLE ExpectedDuration (
    expectedDurationID int  NOT NULL IDENTITY,
    durationText nvarchar(255)  NOT NULL,
    CONSTRAINT ExpectedDuration_pk PRIMARY KEY  (expectedDurationID)
);

-- Table: FavoriteProject
CREATE TABLE FavoriteProject (
    favoriteProjectID int  NOT NULL IDENTITY,
    projectID int  NOT NULL,
    seekerID int  NOT NULL,
    CONSTRAINT FavoriteProject_pk PRIMARY KEY  (favoriteProjectID)
);

-- Table: HasSkill
CREATE TABLE HasSkill (
    hasSkillID int  NOT NULL IDENTITY,
    seekerID int  NOT NULL,
    skillID int  NOT NULL,
    CONSTRAINT HasSkill_pk PRIMARY KEY  (hasSkillID)
);

-- Table: Hirer
CREATE TABLE Hirer (
    hirerID int  NOT NULL,
    companyName nvarchar(255)  NOT NULL,
    CONSTRAINT Hirer_pk PRIMARY KEY  (hirerID)
);

-- Table: NeededSkills
CREATE TABLE NeededSkills (
    neededSkillsID int  NOT NULL IDENTITY,
    projectID int  NOT NULL,
    skillID int  NOT NULL,
    CONSTRAINT NeededSkills_pk PRIMARY KEY  (neededSkillsID)
);

-- Table: Notification
CREATE TABLE Notification (
    notificationID int  NOT NULL IDENTITY,
    userID int  NOT NULL,
    notificationText text  NOT NULL,
    CONSTRAINT Notification_pk PRIMARY KEY  (notificationID)
);

-- Table: Project
CREATE TABLE Project (
    projectID int  NOT NULL IDENTITY,
	projectName nvarchar(50) NOT NULL,
    description text  NOT NULL,
    complexity nvarchar(128)  NOT NULL,
    hirerID int  NOT NULL,
    paymentAmount decimal(8,2)  NOT NULL,
    expectedDurationID int  NOT NULL,
    deadlineDate date  NOT NULL,
	location nvarchar(50) NOT NULL,
	createdDate date NOT NULL,
	hoursPerWeek int NOT NULL,
	major nvarchar(50) NOT NULL,
    CONSTRAINT Project_pk PRIMARY KEY  (projectID)
);

-- Table: Proposal
CREATE TABLE Proposal (
    proposalID int  NOT NULL IDENTITY,
    projectID int  NOT NULL,
    seekerID int  NOT NULL,
    paymentAmount decimal(8,2)  NOT NULL,
    proposalStatusID int  NOT NULL,
    clientGrade int  NULL,
    clientComment text  NULL,
    seekerGrade int  NULL,
	seekerComment text NULL,
	coverLetter text,
	attachment text,
	createdDate date DEFAULT GETDATE(),
	expectedDurationID int,
	link text NULL,
	message text NULL,
	fileName nvarchar(255) NULL,
	path nvarchar(255) NULL,
	dateSeekerDone date null,
    CONSTRAINT Proposal_pk PRIMARY KEY  (proposalID)
);

-- Table: ProposalStatus
CREATE TABLE ProposalStatus (
    proposalStatusID int  NOT NULL IDENTITY,
    statusName nvarchar(32)  NOT NULL,
    CONSTRAINT ProposalStatus_pk PRIMARY KEY  (proposalStatusID)
);

-- Table: Seeker
CREATE TABLE Seeker (
    seekerID int  NOT NULL,
    overview text  NOT NULL,
    titileBio nvarchar(255)  NOT NULL,
    moneyPerHour int  NOT NULL,
    education nvarchar(255)  NOT NULL,
	degree nvarchar(50) NOT NULL,
	major nvarchar(50) NOT NULL,
	hourPerWeek nvarchar(50) default 'None',
    CONSTRAINT Seeker_pk PRIMARY KEY  (seekerID)
);

-- Table: Skill
CREATE TABLE Skill (
    skillID int  NOT NULL IDENTITY,
    skillName nvarchar(128)  NOT NULL,
    CONSTRAINT Skill_pk PRIMARY KEY  (skillID)
);

-- Table: User
CREATE TABLE "User" (
    userID int  NOT NULL IDENTITY,
    password nvarchar(32)  NOT NULL,
    userName nvarchar(32)  NOT NULL,
    fullName nvarchar(32)  NOT NULL,
    email nvarchar(128)  NOT NULL,
    phone nvarchar(10)  NOT NULL,
    location nvarchar(255)  NOT NULL,
    registrationDate date  NOT NULL,
    balance decimal(8,2)  NOT NULL,
	avatar text NOT NULL,
	language nvarchar(50) default 'English',
	languagelv nvarchar(50) default 'Basic',
    CONSTRAINT User_ak_1 UNIQUE (userName),
    CONSTRAINT UserID PRIMARY KEY  (userID)
);
--create  table PayPalKey
CREATE TABLE PaymentFLC (
	paymentId int  NOT NULL IDENTITY,
    userID int NOT NULL,
	CLIENT_ID text NOT NULL,
	CLIENT_SECRET text NOT NULL
    CONSTRAINT Payment PRIMARY KEY  (paymentId)
);

--create  table TransactionHandling
CREATE TABLE TransactionHandling (
	transactionHandlingID int  NOT NULL IDENTITY,
    userID int NOT NULL,
	amountMonney money,
	status bit,	--0: processing, 1:done
	dateCreate date DEFAULT GETDATE(),
	dateDone date,
    CONSTRAINT transactionHandlingID PRIMARY KEY  (transactionHandlingID)
);


-- foreign keys

-- Reference: TransactionHandling_User (table: TransactionHandling)
ALTER TABLE TransactionHandling ADD CONSTRAINT TransactionHandling_User
    FOREIGN KEY (userID)
    REFERENCES "User" (userID);

-- Reference: PaymentFLC_User (table: PaymentFLC)
ALTER TABLE PaymentFLC ADD CONSTRAINT PaymentFLC_User
    FOREIGN KEY (userID)
    REFERENCES "User" (userID);

-- Reference: Contract_Proposal (table: Contract)
ALTER TABLE Contract ADD CONSTRAINT Contract_Proposal
    FOREIGN KEY (proposalID)
    REFERENCES Proposal (proposalID);

-- Reference: ExpectedDuration_Project (table: Project)
ALTER TABLE Project ADD CONSTRAINT ExpectedDuration_Project
    FOREIGN KEY (expectedDurationID)
    REFERENCES ExpectedDuration (expectedDurationID);

	-- Reference: ExpectedDuration_Proposal (table: Proposal)
ALTER TABLE Proposal ADD CONSTRAINT ExpectedDuration_Proposal
    FOREIGN KEY (expectedDurationID)
    REFERENCES ExpectedDuration (expectedDurationID);

-- Reference: FavouriteProject_Project (table: FavoriteProject)
ALTER TABLE FavoriteProject ADD CONSTRAINT FavouriteProject_Project
    FOREIGN KEY (projectID)
    REFERENCES Project (projectID);

-- Reference: FavouriteProject_Seeker (table: FavoriteProject)
ALTER TABLE FavoriteProject ADD CONSTRAINT FavouriteProject_Seeker
    FOREIGN KEY (seekerID)
    REFERENCES Seeker (seekerID);

-- Reference: HasSkill_Seeker (table: HasSkill)
ALTER TABLE HasSkill ADD CONSTRAINT HasSkill_Seeker
    FOREIGN KEY (seekerID)
    REFERENCES Seeker (seekerID);

-- Reference: HasSkill_Skill (table: HasSkill)
ALTER TABLE HasSkill ADD CONSTRAINT HasSkill_Skill
    FOREIGN KEY (skillID)
    REFERENCES Skill (skillID);

-- Reference: NeededSkills_Project (table: NeededSkills)
ALTER TABLE NeededSkills ADD CONSTRAINT NeededSkills_Project
    FOREIGN KEY (projectID)
    REFERENCES Project (projectID);

-- Reference: NeededSkills_Skill (table: NeededSkills)
ALTER TABLE NeededSkills ADD CONSTRAINT NeededSkills_Skill
    FOREIGN KEY (skillID)
    REFERENCES Skill (skillID);

-- Reference: Notification_User (table: Notification)
ALTER TABLE Notification ADD CONSTRAINT Notification_User
    FOREIGN KEY (userID)
    REFERENCES "User" (userID);

-- Reference: Project_Hirer (table: Project)
ALTER TABLE Project ADD CONSTRAINT Project_Hirer
    FOREIGN KEY (hirerID)
    REFERENCES Hirer (hirerID);

-- Reference: ProposalStatus_Proposal (table: Proposal)
ALTER TABLE Proposal ADD CONSTRAINT ProposalStatus_Proposal
    FOREIGN KEY (proposalStatusID)
    REFERENCES ProposalStatus (proposalStatusID);

-- Reference: Proposal_Project (table: Proposal)
ALTER TABLE Proposal ADD CONSTRAINT Proposal_Project
    FOREIGN KEY (projectID)
    REFERENCES Project (projectID);

-- Reference: Proposal_Seeker (table: Proposal)
ALTER TABLE Proposal ADD CONSTRAINT Proposal_Seeker
    FOREIGN KEY (seekerID)
    REFERENCES Seeker (seekerID);

-- Reference: Seeker_User (table: Seeker)
ALTER TABLE Seeker ADD CONSTRAINT Seeker_User
    FOREIGN KEY (seekerID)
    REFERENCES "User" (userID);

-- Reference: User_Hirer (table: Hirer)
ALTER TABLE Hirer ADD CONSTRAINT User_Hirer
    FOREIGN KEY (hirerID)
    REFERENCES "User" (userID);

-- End