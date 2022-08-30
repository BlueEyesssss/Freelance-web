INSERT INTO [User](password, userName, fullName, email, phone, location, registrationDate, balance, avatar)
values
('111111','phuongkha','pham kha','vuamessi91@gmail.com','0101010101','Binh Duong','2022-05-22', 0, 'unknown'),
('111111','tanphat','huynh tan phat','huynhtanphat@gmail.com','0202020202','HCM','2022-05-23', 0, 'unknown'),
('111111','lehuu','le huu','nguyenlehuu@gmail.com','0303030303','Binh Duong','2022-05-22', 0, 'unknown'),
('111111','user01','user one','phamuser1@gmail.com','0404040404','Binh Duong','2022-05-22', 99, 'unknown'),
('111111','user02','user two','phamuser2@gmail.com','0505050505','Binh Duong','2022-05-22', 0, 'unknown')


INSERT INTO [Seeker](seekerID, overview, titileBio, moneyPerHour, education, major, degree)
values
(1, 'i am seeker and my name is Phuong Kha', 'Java developer', 60, 'FPT University', 'software engineer', 'university'),
(2, 'i am seeker and my name is Tan Phat, I am frontend developer', 'HTML/CSS developer', 11, 'FPT University', 'cloud engineer', 'university'),
(3, 'i am seeker and my name is Le Huu', 'HTML/CSS developer', 12, 'FPT University', 'business analysis', 'university')


INSERT INTO Hirer(hirerID, companyName)
values
(4, 'FSoft'),
(5, 'KMS')


INSERT INTO ExpectedDuration(durationText)
values
('less than 1 month'),
('1-3 months'),
('3-6 months'),
('6 or more months')

INSERT INTO Project (description, complexity, hirerID, paymentAmount, expectedDurationID, deadlineDate, projectName, location, createdDate, hoursPerWeek, major)
values
('Web Game VO LAM CHI MONG', 'Expert', 4, 100, 1, '06-13-2021', 'Front-end Of Web Game VO LAM CHI MONG', 'Sai Gon', '2022-05-22', 5, 'Web design'),
('Milk tea selling website', 'Intermediate', 5, 200, 2, '06-14-2021', 'Back-end Of Milk tea selling website', 'Sai Gon', '2022-05-22', 5, 'Front-end'),
('Book selling website', 'Entry', 5, 220, 3, '06-15-2021', 'Front-end Of Book selling website', 'Sai Gon', '2022-05-22', 5, 'Web design'),
('Shoes selling website', 'Entry', 4, 250, 4, '06-16-2021', 'Back-end Of Shoes selling website', 'Sai Gon', '2022-05-22', 5, 'Back-end'),
('Car selling website', 'Intermediate', 4, 300, 2, '06-17-2021', 'Front-end Of Car selling website', 'Sai Gon', '2022-05-22', 5, 'Web design'),
('Char selling website', 'Expert', 4, 150, 2, '06-18-2021', 'Back-end Of Char selling website', 'Sai Gon', '2022-05-22', 5, 'Front-end'),
('Fish selling website', 'Entry', 5, 200, 3, '06-19-2021', 'Front-end Of Fish selling website', 'Sai Gon', '2022-05-22', 5, 'Back-end'),
('Fram game website', 'Intermediate', 4, 250, 1, '06-20-2021', 'Back-end Of Fram game website', 'Sai Gon', '2022-05-22', 5, 'Web design'),
('Shoes selling website', 'Intermediate', 5, 300, 2, '06-21-2021', 'Front-end Of Shoes selling website', 'Sai Gon', '2022-05-22', 5, 'Back-end'),
('Shoes selling website', 'Expert', 4, 190, 3, '06-22-2021', 'Back-end Of Shoes selling website', 'Sai Gon', '2022-05-22', 5, 'Front-end')




INSERT INTO FavoriteProject(projectID, seekerID)
values
(1, 1),
(2, 2),
(3, 3),
(4, 2)

INSERT INTO Skill (skillName)
values
('HTML'),
('CSS'),
('C#'),
('Spring'),
('Node.js'),
('C++'),
('Vue'),
('Java'),
('React'),
('JavaScript'),
('BootStrap'),
('Python'),
('Ruby'),
('SQL'),
('PHP'),
('Test'),
('Docker')


INSERT INTO HasSkill(seekerID, skillID)
values
(1, 1),
(1, 2),
(1, 3),
(2, 11),
(2, 12),
(2, 13)

INSERT INTO NeededSkills(projectID, skillID)
values
(1,1),
(1,2),
(1,3),
(2,4),
(2,5),
(2,10),
(3,1),
(3,9),
(4,5),
(5,6),
(6,17),
(7,17),
(8,16),
(9,15),
(10,14)

INSERT INTO ProposalStatus(statusName)
values 
('proposal sent'),
('proposal invite'),
('proposal rejected'),
('job started'),
('job waiting'),
('job finished unsuccessfully'),
('job finished successfully'),
('reported')

INSERT INTO Proposal(projectID,seekerID,paymentAmount,proposalStatusID, expectedDurationID)
values
(1,1,100,1,1),
(2,1,150,2,2),
(3,1,50,3,3),
(4,1,990,4,4),
(5,1,132,5,3),
(6,1,80,6,2),
(7,1,500,7,1),
(8,1,600,1,1),
(9,1,400,1,2),
(10,1,5000,1,3)

INSERT INTO Contract(proposalID,paymentAmount,startTime,endTime)
values
(6,200,'2022-07-09','2022-08-08'),
(7,300,'2022-07-07','2022-07-08')


INSERT INTO PaymentFLC(userID, CLIENT_ID, CLIENT_SECRET)
VALUES
(1,	'AcBMoWpzjWFZSz8Qg3EcFokud7lTYcTORy5JzRcgzCnruhqiAjOBmWFxzD5oZbklXl1x-gsNiqpTZoxw', 'EH8ZwpRhzPs0Is7DvHoXRglkMiWPAlGitoFdsx1IwrCdVCY-cJwhusmHjEg1pIQKmAy__UMWCx0zmDw9'),
(2, 'AZDjRSuti2FJsDqHPQM6K1HTjsjwyjOhWQ4f4KTDfniY0jNajqi_9hUnfe5oSinzfU8NtAiG6xPY70w-', 'EMCA23BZHuPPvZ3LU7jF9cb4qGY4NlxN95CYX8c8zbAlLOmkqei5_W03rcQFeiPyP1ACSENSnw0YP0sx'),
(3,	'AUeWDtkblqDShE3zNwQ-vuE0xQAt5PnkJSSFxaN8MD4M18SBAlQ8t1NRu6wM9QWbl2ot1F48uLAQiBj3', 'EPzPJ3VQGfByrXGC_pO6qr740w5F176zw-QibLADZ5Z-luqZSzQavcz-1uNmloKlgOM3f2GAMzBZOflH'),
(4, 'AeS1Uk8CbarOXzKpytejuN67eOKRrIJZ9e-XT6mT5qcJEZHIoZBUoepf1vQNYaSHWax_wmYz_D7nyOcA','EDVceUlihYa8uyRmnD726OuOZnsMj3pk4VRpJUDBAfC5SSFOAtTt-k2__UmwScuiWgD8H3AqQuXVURew')

INSERT INTO TransactionHandling(userID, amountMonney, status)
VALUES
(4, 100, 0),
(4, 69, 0)

