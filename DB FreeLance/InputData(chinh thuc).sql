USE [FreelanceManagement9]
GO
SET IDENTITY_INSERT [dbo].[ExpectedDuration] ON 

INSERT [dbo].[ExpectedDuration] ([expectedDurationID], [durationText]) VALUES (1, N'less than 1 month')
INSERT [dbo].[ExpectedDuration] ([expectedDurationID], [durationText]) VALUES (2, N'1-3 months')
INSERT [dbo].[ExpectedDuration] ([expectedDurationID], [durationText]) VALUES (3, N'3-6 months')
INSERT [dbo].[ExpectedDuration] ([expectedDurationID], [durationText]) VALUES (4, N'6 or more months')
SET IDENTITY_INSERT [dbo].[ExpectedDuration] OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (1, N'111111', N'phuongkha', N'pham kha', N'vuamessi9@gmail.com', N'0101010101', N'Binh Duong', CAST(N'2022-05-22' AS Date), CAST(1020.00 AS Decimal(8, 2)), N'anya2.jpg', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (2, N'111111', N'tanphat', N'huynh tan phat', N'huynhtanphat@gmail.com', N'0202020202', N'HCM', CAST(N'2022-05-23' AS Date), CAST(0.00 AS Decimal(8, 2)), N'ib13.png', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (3, N'111111', N'lehuu', N'le huu', N'nguyenlehuu@gmail.com', N'0303030303', N'Binh Duong', CAST(N'2022-05-22' AS Date), CAST(0.00 AS Decimal(8, 2)), N'ib11.png', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (4, N'111111', N'user01', N'user onee', N'phamhuynhphuongkha@gmail.com', N'0404040404', N'Binh Duong', CAST(N'2022-05-22' AS Date), CAST(149.00 AS Decimal(8, 2)), N'ava2.jpg', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (5, N'111111', N'user02', N'user two', N'phamuser2@gmail.com', N'0505050505', N'Binh Duong', CAST(N'2022-05-22' AS Date), CAST(0.00 AS Decimal(8, 2)), N'ib6.png', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (6, N'111111', N'pkha226', N'Pham Huynh Phuong Kha', N'vuamessi9@gmail.com', N'0971746082', N'Ho Chi MInh', CAST(N'2022-07-31' AS Date), CAST(0.00 AS Decimal(8, 2)), N'ava2.jpg', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (7, N'111111', N'huong1', N'Cam Huong', N'khaphpse151400@fpt.edu.vn', N'0986775129', N'Ho Chi MInh', CAST(N'2022-07-31' AS Date), CAST(0.00 AS Decimal(8, 2)), N'anger.png', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (8, N'111111', N'user03', N'Jeremy Renner', N'Jeremy@gmail.com', N'0354187014', N'Canada', CAST(N'2022-05-22' AS Date), CAST(0.00 AS Decimal(8, 2)), N'unknown', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (9, N'111111', N'user04', N'Michael B. Jordan', N'Michael@gmail.com', N'0354187015', N'New York', CAST(N'2022-05-22' AS Date), CAST(0.00 AS Decimal(8, 2)), N'unknown', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (10, N'111111', N'user05', N'Chris Evans', N'Chris@gmail.com', N'0354187016', N'Binh Duong', CAST(N'2022-05-22' AS Date), CAST(0.00 AS Decimal(8, 2)), N'unknown', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (11, N'111111', N'user06', N'Tom Holland', N'Holland@gmail.com', N'0354187017', N'Canada', CAST(N'2022-05-22' AS Date), CAST(0.00 AS Decimal(8, 2)), N'unknown', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (12, N'111111', N'user07', N'Zendaya', N'Zendaya@gmail.com', N'0354187018', N'New York', CAST(N'2022-05-22' AS Date), CAST(0.00 AS Decimal(8, 2)), N'unknown', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (13, N'111111', N'user08', N'Mark Ruffalo', N'Zendaya@gmail.com', N'0354187024', N'New York', CAST(N'2022-05-22' AS Date), CAST(1000.00 AS Decimal(8, 2)), N'unknown', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (14, N'111111', N'user09', N'Chris Hemsworth', N'Zendaya@gmail.com', N'0354187023', N'New York', CAST(N'2022-05-22' AS Date), CAST(1000.00 AS Decimal(8, 2)), N'unknown', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (15, N'111111', N'user10', N'Scarlett Johansson', N'Zendaya@gmail.com', N'0354187022', N'New York', CAST(N'2022-05-22' AS Date), CAST(1000.00 AS Decimal(8, 2)), N'unknown', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (16, N'111111', N'user11', N'Zoe Saldana', N'Zendaya@gmail.com', N'0354187021', N'New York', CAST(N'2022-05-22' AS Date), CAST(1000.00 AS Decimal(8, 2)), N'unknown', N'English', N'Basic')
INSERT [dbo].[User] ([userID], [password], [userName], [fullName], [email], [phone], [location], [registrationDate], [balance], [avatar], [language], [languagelv]) VALUES (17, N'111111', N'user12', N'Robert Downey Jr.', N'Zendaya@gmail.com', N'0354187020', N'New York', CAST(N'2022-05-22' AS Date), CAST(1000.00 AS Decimal(8, 2)), N'unknown', N'English', N'Basic')
SET IDENTITY_INSERT [dbo].[User] OFF
GO
INSERT [dbo].[Hirer] ([hirerID], [companyName]) VALUES (4, N'FSoft')
INSERT [dbo].[Hirer] ([hirerID], [companyName]) VALUES (5, N'KMS')
INSERT [dbo].[Hirer] ([hirerID], [companyName]) VALUES (7, N'KMS HCM')
INSERT [dbo].[Hirer] ([hirerID], [companyName]) VALUES (13, N'TheGioiDIDong')
INSERT [dbo].[Hirer] ([hirerID], [companyName]) VALUES (14, N'DienMayXanh')
INSERT [dbo].[Hirer] ([hirerID], [companyName]) VALUES (15, N'ValeyDish')
GO
SET IDENTITY_INSERT [dbo].[Project] ON 

INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (1, N'Front-end Of Web Game VO LAM CHI MONG', N'Web Game VO LAM CHI MONG', N'Expert', 4, CAST(100.00 AS Decimal(8, 2)), 1, CAST(N'2021-06-13' AS Date), N'Sai Gon', CAST(N'2022-05-22' AS Date), 5, N'Web design')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (2, N'Back-end Of Milk tea selling website', N'Milk tea selling website', N'Intermediate', 5, CAST(200.00 AS Decimal(8, 2)), 2, CAST(N'2021-06-14' AS Date), N'Sai Gon', CAST(N'2022-05-22' AS Date), 5, N'Front-end')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (3, N'Front-end Of Book selling website', N'Book selling website', N'Entry', 5, CAST(220.00 AS Decimal(8, 2)), 3, CAST(N'2021-06-15' AS Date), N'Sai Gon', CAST(N'2022-05-22' AS Date), 5, N'Web design')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (4, N'Back-end Of Shoes selling website', N'Shoes selling website', N'Entry', 4, CAST(250.00 AS Decimal(8, 2)), 4, CAST(N'2021-06-16' AS Date), N'Sai Gon', CAST(N'2022-05-22' AS Date), 5, N'Back-end')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (5, N'Front-end Of Car selling website', N'Car selling website', N'Intermediate', 4, CAST(300.00 AS Decimal(8, 2)), 2, CAST(N'2021-06-17' AS Date), N'Sai Gon', CAST(N'2022-05-22' AS Date), 5, N'Web design')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (6, N'Back-end Of Char selling website', N'Char selling website', N'Expert', 4, CAST(150.00 AS Decimal(8, 2)), 2, CAST(N'2021-06-18' AS Date), N'Sai Gon', CAST(N'2022-05-22' AS Date), 5, N'Front-end')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (7, N'Front-end Of Fish selling website', N'Fish selling website', N'Entry', 5, CAST(200.00 AS Decimal(8, 2)), 3, CAST(N'2021-06-19' AS Date), N'Sai Gon', CAST(N'2022-05-22' AS Date), 5, N'Back-end')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (8, N'Back-end Of Fram game website', N'Fram game website', N'Intermediate', 4, CAST(250.00 AS Decimal(8, 2)), 1, CAST(N'2021-06-20' AS Date), N'Sai Gon', CAST(N'2022-05-22' AS Date), 5, N'Web design')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (9, N'Front-end Of Shoes selling website', N'Shoes selling website', N'Intermediate', 5, CAST(300.00 AS Decimal(8, 2)), 2, CAST(N'2021-06-21' AS Date), N'Sai Gon', CAST(N'2022-05-22' AS Date), 5, N'Back-end')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (10, N'Back-end Of Shoes selling website', N'Shoes selling website', N'Expert', 4, CAST(190.00 AS Decimal(8, 2)), 3, CAST(N'2021-06-22' AS Date), N'Sai Gon', CAST(N'2022-05-22' AS Date), 5, N'Front-end')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (11, N'Front-end Of Laptop selling website', N'I need a programmer to design data for the website,
 to be fluent in everything that the website needs, 
to be responsible at work, ready to do the best you can.', N'Intermediate', 7, CAST(100.00 AS Decimal(8, 2)), 1, CAST(N'2022-08-04' AS Date), N'Ho Chi MInh', CAST(N'2022-07-31' AS Date), 20, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (12, N'Information Technology  at TMA Solutions', N'- Project-based internship, mentored by experienced experts from TMA (Subject Matter Expert) projects
- Be trained:
Soft skills, professional working skills
Software development process
Technology
Foreign Language
- Participate in the implementation of sample projects (Biz, Mobile, Testing, DS/AI/ML, ...) and receive project assignment in the first month of the internship.', N'Intermediate', 4, CAST(100.00 AS Decimal(8, 2)), 1, CAST(N'2022-08-24' AS Date), N'Ho Chi MInh', CAST(N'2022-08-01' AS Date), 20, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (13, N'Opencommerce Group', N'• Development of technology products; technology support tools for products.
• Analyze and develop services, systems, APIs for system integration.
• Participating in maintenance and upgrading of existing technology products and services to ensure stable product operation.
• Proposing solutions, new technology trends to improve product quality.
Candidate Requirements
• Proficient in at least one of the following languages: Golang, Java, PHP, Python, Javascript, Ruby, Git...
(Not limited to programming languages, welcome all candidates who want to work in technology to use at OCG)
• Understanding of software engineering, microservices.
• Knowledge and experience in database (sql + nosql) is an advantage.', N'Intermediate', 4, CAST(20.00 AS Decimal(8, 2)), 3, CAST(N'2022-08-19' AS Date), N'Ho Chi MInh', CAST(N'2022-08-01' AS Date), 20, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (14, N'Cobol Intern', N'DXC Vietnam is launching and IPA-Cobol training with 10-12 positions
All hands-on practices are designed by our internal engineers.
Our experts will train you Cobol and related technologies, DXC Insurance Product and domain knowledge. After the training, you will be able to work as a Cobol Developer for an Insurance project at DXC where you can further advance your career.', N'Intermediate', 4, CAST(20.00 AS Decimal(8, 2)), 3, CAST(N'2022-08-17' AS Date), N'Tan Binh, Ho Chi Minh City, Vietnam', CAST(N'2022-08-01' AS Date), 20, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (15, N'Java Confidential Company', N'Report to the Vietnam Application Delivery Lead, work as part of the engineering team for technical and architecture design and solution delivery
? Work with IT product owners and business analysts and business stakeholders on shaping project/business requirements and solutions
? Assess, design, implement and/or support world-class information technology architectures, spanning from simple IT projects to large-scale, enterprise-level change                                                        ', N'Expert', 4, CAST(20.00 AS Decimal(8, 2)), 2, CAST(N'2022-08-18' AS Date), N'Ho Chi Minh City, Vietnam', CAST(N'2022-08-01' AS Date), 20, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (16, N'Java Developer Cuckookoo', N'Required:
At least 2 years of experience in software development.
Experience in Java/Kotlin and J2EE frameworks such as Spring, Micronaut?
Have experience in AWS
Strong background in Relational Databases, SQL and ORM technologies.
Experience in service-oriented development, software architecture paradigms and designs patterns
Experience in REST API design and implementation, message queues, OAuth authorization mechanisms, JSON Web Token
Exp                                                        ', N'Intermediate', 4, CAST(30.00 AS Decimal(8, 2)), 2, CAST(N'2022-08-17' AS Date), N'Go Vap, Ho Chi Minh City, Vietnam', CAST(N'2022-08-01' AS Date), 20, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (17, N'Kyanon Digital', N'You will:
- Participate in building backend systems for web, mobile, messaging platform, ..
- Collaborate with senior developers to develop new solutions
You should have:
- Have knowledge, have done related exercises or projects about Java, Spring
- Knowledge of CMS, Javascript, CSS
- Progressive spirit, eager to learn
- Being able to work full time is an advantage                                                  ', N'Intermediate', 4, CAST(30.00 AS Decimal(8, 2)), 2, CAST(N'2022-08-17' AS Date), N'Ho Chi MInh', CAST(N'2022-08-01' AS Date), 30, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (18, N'Java DXC VIETNAM', N'1. Fresh graduates or final-year students in Computer Science, Information Technology, Software Engineering or related technical field. Third-year students can also be considered.
2. Good knowledge in Object-oriented programming concept.
3. Basic English communication skills.
4. Has knowledge or relevant work experience in any of the following programming languages or technologies: Java/Java EE, .NET, C#, C++, C, JavaScript, SQL, System, Li                                                        ', N'Intermediate', 4, CAST(20.00 AS Decimal(8, 2)), 4, CAST(N'2022-08-25' AS Date), N'Tan Binh, Ho Chi Minh City, Vietnam', CAST(N'2022-08-01' AS Date), 20, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (19, N'Taisei Group', N'Research and develop mobile applications for company software (Parking, PSM...)
Develop website system for parking system, elevator stratification
Actively work with the development team and check the quality of software products, monitor the progress
Detect, report, track software bugs
Perform testing to make sure the software meets customer requirements and is free of bugs
Other tasks as assigned by the Head of Department                                                        ', N'Intermediate', 4, CAST(20.00 AS Decimal(8, 2)), 1, CAST(N'2022-08-25' AS Date), N'Tan Binh, Ho Chi Minh City, Vietnam', CAST(N'2022-08-01' AS Date), 20, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (21, N'Monstarlab Vietnam', N'* What Will You Do
- Analyze system requirement and review specifications.
- Build, and maintain efficient, reusable, and reliable Java code
- Ensure Unit testing is done for all developed code.
* What We Can Offer
- 13th month pay (Yearly bonus).
- 14th month pay (Profit bonus, based on business result).
- Performance review and salary adjustment 2 times a year.
- Promotion opportunity.
- Monthly team-building fund (200k/person/month).
- E                                                        ', N'Entry', 4, CAST(20.00 AS Decimal(8, 2)), 3, CAST(N'2022-08-26' AS Date), N'Ho Chi MInh', CAST(N'2022-08-01' AS Date), 22, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (22, N'Be Solutions', N'At least 1 year of experience in web development technologies.
Have strong knowledge of core Java and J2EE applications such as Spring Boot, Hibernate, JPA, JSP, etc.
Experience in Web Services (RESTful, SOAP).
Experience in MySQL, SQL Server, MongoDB.
Experience in Maven, Git, SVN.
Participate in sprint planning meetings and provide effort estimates for JIRA tickets
Good writing and reading skills in English.                                                        ', N'Intermediate', 4, CAST(20.00 AS Decimal(8, 2)), 1, CAST(N'2022-08-24' AS Date), N'Ho Chi MInh', CAST(N'2022-08-01' AS Date), 22, N'district 1, Ho Chi Minh City, Vietnam')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (23, N'DEK Technologies', N'We are looking for experienced and highly enthusiastic Java Developers to work on Java project. Implementing and configuring virtual or physical network devices, developing systems and testing, this is the common task.
By joining our team, you will be responsible for development, maintenance and troubleshooting in production systems.
At DEK Technologies Vietnam, you will live with Agile & Lean principles where employees are empowered at all                                                        ', N'Intermediate', 4, CAST(20.00 AS Decimal(8, 2)), 1, CAST(N'2022-08-25' AS Date), N'Ho Chi MInh', CAST(N'2022-08-01' AS Date), 22, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (24, N'Pinetree Securities Corporation', N'Participate in the development of Pinetree''s digital products including new feature development, feature enhancement, bug detection and correction.
Work with team leaders and managers to agree on solutions and complete assigned tasks. An alternative solution can be suggested if it is more reasonable.
Design and build scalable and RestFul APIs.
Coordinate with Frontend team to come up with a solution, a common way to connect API between the two parties
Troubles                                    ', N'Intermediate', 4, CAST(20.00 AS Decimal(8, 2)), 1, CAST(N'2022-08-17' AS Date), N'Ha Noi, Viet Nam', CAST(N'2022-08-01' AS Date), 22, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (25, N'Senavi', N'Java Developer
Chalasoft
?? we are a solid team, located in Vietnam and Russia, with 5 years experiences in working with global clients in financial software development
?? We are planning to grow the team in Vietnam to 200 in the next 3 years.
?? Location: Cau Giay, Ha Noi
Project Devexperts
Our client is a global company in the development of software for financial markets and trading industry. Devexperts has over 500 engineers all over t                                                        ', N'Expert', 5, CAST(20.00 AS Decimal(8, 2)), 1, CAST(N'2022-08-19' AS Date), N'Ho Chi MInh', CAST(N'2022-08-01' AS Date), 22, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (26, N'PADITECH', N'Apply knowledge of technology, processes, tools and software development methods according to Agile/Scrum model to fulfill business requirements or participate in the implementation of related projects.
Participate in projects using the Java programming language and related technologies.
Automated Unit test/API code development
Participating in projects of major economic and financial group partners of Korea, the US, and Vietnam
Always go t                                                        ', N'Intermediate', 5, CAST(20.00 AS Decimal(8, 2)), 2, CAST(N'2022-08-18' AS Date), N'Ha Noi, Viet Nam', CAST(N'2022-08-01' AS Date), 22, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (27, N'Andoir SHAREWORK', N'- At least 2-years experiences with native Android development
(Android Studio, Kotlin, Java, Google API?).
- Strong understanding of Object Oriented Design, broadcast receiver, activity, fragment and service lifecycle.
- Experience in writing OOP code and develop apps using MVC, MVP or MVVM.
- In-depth understanding of UI component & customization, proficient in creating flexible UI for various device screen sizes.
- Strong experience on c                                                        ', N'Expert', 5, CAST(20.00 AS Decimal(8, 2)), 1, CAST(N'2022-08-12' AS Date), N'Tan Binh, Ho Chi Minh City, Vietnam', CAST(N'2022-08-01' AS Date), 22, N'software engineer')
INSERT [dbo].[Project] ([projectID], [projectName], [description], [complexity], [hirerID], [paymentAmount], [expectedDurationID], [deadlineDate], [location], [createdDate], [hoursPerWeek], [major]) VALUES (28, N'Blameo Technology', N'  - Participate in design, functional development, performance optimization for domestic and foreign projects and products of the company
  - Research new technologies, coordinate with other members to complete the work schedule                                                     ', N'Intermediate', 5, CAST(20.00 AS Decimal(8, 2)), 2, CAST(N'2022-08-25' AS Date), N'Ha Noi, Viet Nam', CAST(N'2022-08-01' AS Date), 22, N'software engineer')
SET IDENTITY_INSERT [dbo].[Project] OFF
GO
SET IDENTITY_INSERT [dbo].[ProposalStatus] ON 

INSERT [dbo].[ProposalStatus] ([proposalStatusID], [statusName]) VALUES (1, N'proposal sent')
INSERT [dbo].[ProposalStatus] ([proposalStatusID], [statusName]) VALUES (2, N'proposal invite')
INSERT [dbo].[ProposalStatus] ([proposalStatusID], [statusName]) VALUES (3, N'proposal rejected')
INSERT [dbo].[ProposalStatus] ([proposalStatusID], [statusName]) VALUES (4, N'job started')
INSERT [dbo].[ProposalStatus] ([proposalStatusID], [statusName]) VALUES (5, N'job waiting')
INSERT [dbo].[ProposalStatus] ([proposalStatusID], [statusName]) VALUES (6, N'job finished unsuccessfully')
INSERT [dbo].[ProposalStatus] ([proposalStatusID], [statusName]) VALUES (7, N'job finished successfully')
INSERT [dbo].[ProposalStatus] ([proposalStatusID], [statusName]) VALUES (8, N'reported')
SET IDENTITY_INSERT [dbo].[ProposalStatus] OFF
GO
INSERT [dbo].[Seeker] ([seekerID], [overview], [titileBio], [moneyPerHour], [education], [degree], [major], [hourPerWeek]) VALUES (1, N'i am seeker and my name is Phuong Kha', N'Java developer', 60, N'FPT University', N'university', N'software engineer', N'None')
INSERT [dbo].[Seeker] ([seekerID], [overview], [titileBio], [moneyPerHour], [education], [degree], [major], [hourPerWeek]) VALUES (2, N'i am seeker and my name is Tan Phat, I am frontend developer', N'HTML/CSS developer', 11, N'FPT University', N'university', N'cloud engineer', N'None')
INSERT [dbo].[Seeker] ([seekerID], [overview], [titileBio], [moneyPerHour], [education], [degree], [major], [hourPerWeek]) VALUES (3, N'i am seeker and my name is Le Huu', N'HTML/CSS developer', 12, N'FPT University', N'university', N'business analysis', N'None')
INSERT [dbo].[Seeker] ([seekerID], [overview], [titileBio], [moneyPerHour], [education], [degree], [major], [hourPerWeek]) VALUES (6, N'I always try to improve myself every day to become a better version', N'Java developer, BackEnd', 20, N'FPT University HCM', N'College degree', N'software engineer', N'None')
INSERT [dbo].[Seeker] ([seekerID], [overview], [titileBio], [moneyPerHour], [education], [degree], [major], [hourPerWeek]) VALUES (7, N'i am seeker and i am a good man', N'HTML/CSS developer', 12, N'FPT University', N'university', N'business analysis', N'None')
INSERT [dbo].[Seeker] ([seekerID], [overview], [titileBio], [moneyPerHour], [education], [degree], [major], [hourPerWeek]) VALUES (8, N'i am seeker and i am a good man', N'HTML/CSS developer', 12, N'FPT University', N'university', N'business analysis', N'None')
INSERT [dbo].[Seeker] ([seekerID], [overview], [titileBio], [moneyPerHour], [education], [degree], [major], [hourPerWeek]) VALUES (9, N'i am seeker and i am a good man', N'HTML/CSS developer', 12, N'FPT University', N'university', N'business analysis', N'None')
INSERT [dbo].[Seeker] ([seekerID], [overview], [titileBio], [moneyPerHour], [education], [degree], [major], [hourPerWeek]) VALUES (10, N'i am seeker and i am a good man', N'HTML/CSS developer', 12, N'FPT University', N'university', N'business analysis', N'None')
GO
SET IDENTITY_INSERT [dbo].[Proposal] ON 

INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (1, 1, 1, CAST(100.00 AS Decimal(8, 2)), 1, NULL, NULL, NULL, NULL, NULL, NULL, CAST(N'2022-07-31' AS Date), 1, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (2, 2, 1, CAST(150.00 AS Decimal(8, 2)), 2, NULL, NULL, NULL, NULL, NULL, NULL, CAST(N'2022-07-31' AS Date), 2, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (3, 3, 1, CAST(50.00 AS Decimal(8, 2)), 3, NULL, NULL, NULL, NULL, NULL, NULL, CAST(N'2022-07-31' AS Date), 3, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (5, 5, 1, CAST(132.00 AS Decimal(8, 2)), 5, NULL, NULL, NULL, NULL, N'i can do this', NULL, CAST(N'2022-07-31' AS Date), 3, N'...', N'Done', N'ib7.jfif', N'resources\ava4.jpg', CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (6, 6, 1, CAST(80.00 AS Decimal(8, 2)), 6, 5, 'Good', 5,  N'good', N'i can do this', '', CAST(N'2022-07-31' AS Date), 2, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (7, 7, 1, CAST(500.00 AS Decimal(8, 2)), 7, 2, 'bad', 2,  N'bad', N'i can do this', '', CAST(N'2022-07-31' AS Date), 1, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (8, 8, 1, CAST(600.00 AS Decimal(8, 2)), 1, NULL, NULL, NULL, NULL, NULL, NULL, CAST(N'2022-07-31' AS Date), 1, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (9, 9, 1, CAST(400.00 AS Decimal(8, 2)), 1, NULL, NULL, NULL, NULL, NULL, NULL, CAST(N'2022-07-31' AS Date), 2, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (10, 10, 1, CAST(5000.00 AS Decimal(8, 2)), 1, NULL, NULL, NULL, NULL, NULL, NULL, CAST(N'2022-07-31' AS Date), 3, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (11, 13, 1, CAST(10.00 AS Decimal(8, 2)), 7, 2, 'bad', 2,  N'bad', N'i can do this', '', CAST(N'2022-08-01' AS Date), 1, N'...', N'Done', N'4e718e2f3cf7e017b77725fe0a1a393c.jpg', N'resources\4e718e2f3cf7e017b77725fe0a1a393c.jpg', CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (12, 14, 1, CAST(10.00 AS Decimal(8, 2)), 7, 1, 'bad', 1, N'Bad', N'i can do this', N'', CAST(N'2022-08-01' AS Date), 1, N'...', N'Done', N'ava6.png', N'resources\ava6.png', CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (13, 12, 1, CAST(10.00 AS Decimal(8, 2)), 6, 5, 'good', 5,  N'good', N'i can do this', '', CAST(N'2022-08-01' AS Date), 3, N'...', N'Done', N'ava6.png', N'resources\ava6.png', CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (14, 17, 1, CAST(10.00 AS Decimal(8, 2)), 7, 2, 'bad', 2, N'bad', N'i can do this', N'', CAST(N'2022-08-01' AS Date), 1, N'...', N'Done', N'ava6.png', N'resources\ava6.png', CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (16, 18, 1, CAST(10.00 AS Decimal(8, 2)), 7, 1, 'bad', 2,  N'bad', N'i can do this', '', CAST(N'2022-08-01' AS Date), 2, N'...', N'Done', N'ava6.png', N'resources\ava6.png', CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (18, 16, 1, CAST(10.00 AS Decimal(8, 2)), 6, 5, 'good', 5,  N'good', N'i can do this', '', CAST(N'2022-08-01' AS Date), 1, N'...', N'Done', N'ib7.jfif', N'resources\ib7.jfif', CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (19, 15, 1, CAST(10.00 AS Decimal(8, 2)), 8, NULL, NULL, NULL, NULL, N'.', N'', CAST(N'2022-08-01' AS Date), 2, N'...', N'Done', N'ava4.jpg', N'resources\ava4.jpg', CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (21, 19, 1, CAST(10.00 AS Decimal(8, 2)), 6, 5, 'good', 5,  N'good', N'i can do this', '', CAST(N'2022-08-01' AS Date), 2, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (22, 24, 1, CAST(10.00 AS Decimal(8, 2)), 1, NULL, NULL, NULL, NULL, N' I have the ability to accept this job, I have experience in the field related to the project that I believe I can do, help the project complete as your expectation.
', N'https://www.linkedin.com/in/huynh-phat-31235a214/', CAST(N'2022-08-02' AS Date), 1, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (23, 24, 3, CAST(10.00 AS Decimal(8, 2)), 1, NULL, NULL, NULL, NULL, N'I have the ability to accept this job, I have experience in the field related to the project that I believe I can do, help the project complete as your expectation.
', N'https://www.linkedin.com/in/huynh-phat-31235a214/', CAST(N'2022-08-02' AS Date), 2, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Proposal] ([proposalID], [projectID], [seekerID], [paymentAmount], [proposalStatusID], [clientGrade], [clientComment], [seekerGrade], [seekerComment], [coverLetter], [attachment], [createdDate], [expectedDurationID], [link], [message], [fileName], [path], [dateSeekerDone]) VALUES (24, 24, 2, CAST(10.00 AS Decimal(8, 2)), 1, NULL, NULL, NULL, NULL, N'I have the ability to accept this job, I have experience in the field related to the project that I believe I can do, help the project complete as your expectation.
', N'https://www.linkedin.com/in/huynh-phat-31235a214/', CAST(N'2022-08-02' AS Date), 3, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Proposal] OFF
GO
SET IDENTITY_INSERT [dbo].[FavoriteProject] ON 

INSERT [dbo].[FavoriteProject] ([favoriteProjectID], [projectID], [seekerID]) VALUES (1, 1, 1)
INSERT [dbo].[FavoriteProject] ([favoriteProjectID], [projectID], [seekerID]) VALUES (2, 2, 2)
INSERT [dbo].[FavoriteProject] ([favoriteProjectID], [projectID], [seekerID]) VALUES (3, 3, 3)
INSERT [dbo].[FavoriteProject] ([favoriteProjectID], [projectID], [seekerID]) VALUES (4, 4, 2)
SET IDENTITY_INSERT [dbo].[FavoriteProject] OFF
GO
SET IDENTITY_INSERT [dbo].[Skill] ON 

INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (1, N'HTML')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (2, N'CSS')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (3, N'C#')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (4, N'Spring')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (5, N'Node.js')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (6, N'C++')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (7, N'Vue')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (8, N'Java')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (9, N'React')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (10, N'JavaScript')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (11, N'BootStrap')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (12, N'Python')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (13, N'Ruby')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (14, N'SQL')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (15, N'PHP')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (16, N'Test')
INSERT [dbo].[Skill] ([skillID], [skillName]) VALUES (17, N'Docker')
SET IDENTITY_INSERT [dbo].[Skill] OFF
GO
SET IDENTITY_INSERT [dbo].[NeededSkills] ON 

INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (1, 1, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (2, 1, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (3, 1, 3)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (4, 2, 4)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (5, 2, 5)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (6, 2, 10)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (7, 3, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (8, 3, 9)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (9, 4, 5)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (10, 5, 6)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (11, 6, 17)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (12, 7, 17)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (13, 8, 16)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (14, 9, 15)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (15, 10, 14)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (16, 11, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (17, 11, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (18, 11, 15)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (27, 13, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (28, 13, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (29, 13, 3)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (30, 13, 14)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (35, 12, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (36, 12, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (37, 12, 3)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (38, 12, 14)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (39, 14, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (40, 14, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (41, 14, 7)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (42, 14, 12)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (43, 14, 15)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (44, 15, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (45, 15, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (46, 15, 3)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (47, 15, 17)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (48, 16, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (49, 16, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (50, 16, 9)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (51, 16, 10)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (52, 17, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (53, 17, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (54, 17, 11)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (55, 17, 15)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (56, 18, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (57, 18, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (58, 18, 10)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (59, 18, 12)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (60, 19, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (61, 19, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (62, 19, 11)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (63, 19, 17)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (64, 21, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (65, 21, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (66, 21, 10)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (67, 21, 16)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (68, 22, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (69, 22, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (70, 22, 11)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (71, 22, 13)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (72, 22, 17)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (73, 23, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (74, 23, 9)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (75, 23, 14)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (76, 23, 15)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (77, 24, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (78, 24, 6)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (79, 24, 11)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (80, 24, 16)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (81, 25, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (82, 25, 2)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (83, 25, 14)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (84, 25, 17)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (85, 26, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (86, 26, 13)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (87, 26, 16)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (88, 26, 17)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (89, 27, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (90, 27, 10)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (91, 27, 12)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (92, 27, 15)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (93, 28, 1)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (94, 28, 9)
INSERT [dbo].[NeededSkills] ([neededSkillsID], [projectID], [skillID]) VALUES (95, 28, 11)
SET IDENTITY_INSERT [dbo].[NeededSkills] OFF
GO
SET IDENTITY_INSERT [dbo].[Contract] ON 

INSERT [dbo].[Contract] ([contractID], [proposalID], [paymentAmount], [startTime], [endTime]) VALUES (1, 6, CAST(200.00 AS Decimal(8, 2)), CAST(N'2022-07-09' AS Date), CAST(N'2022-08-08' AS Date))
INSERT [dbo].[Contract] ([contractID], [proposalID], [paymentAmount], [startTime], [endTime]) VALUES (2, 7, CAST(300.00 AS Decimal(8, 2)), CAST(N'2022-07-07' AS Date), CAST(N'2022-07-08' AS Date))
INSERT [dbo].[Contract] ([contractID], [proposalID], [paymentAmount], [startTime], [endTime]) VALUES (3, 11, CAST(10.00 AS Decimal(8, 2)), CAST(N'2022-08-01' AS Date), CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Contract] ([contractID], [proposalID], [paymentAmount], [startTime], [endTime]) VALUES (4, 12, CAST(10.00 AS Decimal(8, 2)), CAST(N'2022-08-01' AS Date), CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Contract] ([contractID], [proposalID], [paymentAmount], [startTime], [endTime]) VALUES (5, 13, CAST(10.00 AS Decimal(8, 2)), CAST(N'2022-08-01' AS Date), CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Contract] ([contractID], [proposalID], [paymentAmount], [startTime], [endTime]) VALUES (6, 14, CAST(10.00 AS Decimal(8, 2)), CAST(N'2022-08-01' AS Date), CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Contract] ([contractID], [proposalID], [paymentAmount], [startTime], [endTime]) VALUES (7, 16, CAST(10.00 AS Decimal(8, 2)), CAST(N'2022-08-01' AS Date), CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Contract] ([contractID], [proposalID], [paymentAmount], [startTime], [endTime]) VALUES (8, 18, CAST(10.00 AS Decimal(8, 2)), CAST(N'2022-08-01' AS Date), CAST(N'2022-08-01' AS Date))
INSERT [dbo].[Contract] ([contractID], [proposalID], [paymentAmount], [startTime], [endTime]) VALUES (9, 19, CAST(10.00 AS Decimal(8, 2)), CAST(N'2022-08-01' AS Date), CAST(N'2020-01-01' AS Date))
INSERT [dbo].[Contract] ([contractID], [proposalID], [paymentAmount], [startTime], [endTime]) VALUES (10, 21, CAST(10.00 AS Decimal(8, 2)), CAST(N'2022-08-01' AS Date), CAST(N'2022-08-02' AS Date))
SET IDENTITY_INSERT [dbo].[Contract] OFF
GO
SET IDENTITY_INSERT [dbo].[HasSkill] ON 

INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (1, 1, 1)
INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (2, 1, 2)
INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (3, 1, 3)
INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (4, 2, 11)
INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (5, 2, 12)
INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (6, 2, 13)
INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (7, 6, 1)
INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (8, 6, 2)
INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (9, 6, 3)
INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (10, 3, 1)
INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (11, 3, 2)
INSERT [dbo].[HasSkill] ([hasSkillID], [seekerID], [skillID]) VALUES (12, 3, 11)
SET IDENTITY_INSERT [dbo].[HasSkill] OFF
GO
SET IDENTITY_INSERT [dbo].[TransactionHandling] ON 

INSERT [dbo].[TransactionHandling] ([transactionHandlingID], [userID], [amountMonney], [status], [dateCreate], [dateDone]) VALUES (1, 4, 100.0000, 0, CAST(N'2022-07-31' AS Date), NULL)
INSERT [dbo].[TransactionHandling] ([transactionHandlingID], [userID], [amountMonney], [status], [dateCreate], [dateDone]) VALUES (2, 4, 69.0000, 0, CAST(N'2022-07-31' AS Date), NULL)
INSERT [dbo].[TransactionHandling] ([transactionHandlingID], [userID], [amountMonney], [status], [dateCreate], [dateDone]) VALUES (3, 1, 10.0000, 1, CAST(N'2022-08-01' AS Date), CAST(N'2022-08-01' AS Date))
SET IDENTITY_INSERT [dbo].[TransactionHandling] OFF
GO
SET IDENTITY_INSERT [dbo].[PaymentFLC] ON 

INSERT [dbo].[PaymentFLC] ([paymentId], [userID], [CLIENT_ID], [CLIENT_SECRET]) VALUES (1, 1, N'AcBMoWpzjWFZSz8Qg3EcFokud7lTYcTORy5JzRcgzCnruhqiAjOBmWFxzD5oZbklXl1x-gsNiqpTZoxw', N'EH8ZwpRhzPs0Is7DvHoXRglkMiWPAlGitoFdsx1IwrCdVCY-cJwhusmHjEg1pIQKmAy__UMWCx0zmDw9')
INSERT [dbo].[PaymentFLC] ([paymentId], [userID], [CLIENT_ID], [CLIENT_SECRET]) VALUES (2, 2, N'AZDjRSuti2FJsDqHPQM6K1HTjsjwyjOhWQ4f4KTDfniY0jNajqi_9hUnfe5oSinzfU8NtAiG6xPY70w-', N'EMCA23BZHuPPvZ3LU7jF9cb4qGY4NlxN95CYX8c8zbAlLOmkqei5_W03rcQFeiPyP1ACSENSnw0YP0sx')
INSERT [dbo].[PaymentFLC] ([paymentId], [userID], [CLIENT_ID], [CLIENT_SECRET]) VALUES (3, 3, N'AUeWDtkblqDShE3zNwQ-vuE0xQAt5PnkJSSFxaN8MD4M18SBAlQ8t1NRu6wM9QWbl2ot1F48uLAQiBj3', N'EPzPJ3VQGfByrXGC_pO6qr740w5F176zw-QibLADZ5Z-luqZSzQavcz-1uNmloKlgOM3f2GAMzBZOflH')
INSERT [dbo].[PaymentFLC] ([paymentId], [userID], [CLIENT_ID], [CLIENT_SECRET]) VALUES (4, 4, N'AeS1Uk8CbarOXzKpytejuN67eOKRrIJZ9e-XT6mT5qcJEZHIoZBUoepf1vQNYaSHWax_wmYz_D7nyOcA', N'EDVceUlihYa8uyRmnD726OuOZnsMj3pk4VRpJUDBAfC5SSFOAtTt-k2__UmwScuiWgD8H3AqQuXVURew')
SET IDENTITY_INSERT [dbo].[PaymentFLC] OFF
GO
