<%-- 
    Document   : postedProjectDetail
    Created on : Jun 20, 2022, 5:16:25 PM
    Author     : Phat
--%>

<%@page import="sample.proposal.ProposalDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="sample.project.ProjectDTO"%>
<%@page import="sample.hirer.HirerDTO"%>
<%@page import="sample.user.UserDTO"%>
<%@page import="sample.user.UserDTO"%>
<%@page import="sample.seeker.SeekerDTO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><!-- This site was created in Webflow. https://www.webflow.com -->
<!-- Last Published: Thu Jun 23 2022 03:59:11 GMT+0000 (Coordinated Universal Time) -->
<html data-wf-domain="huynh-tan-phats-fantabulous-site.webflow.io" data-wf-page="62aa7d13e81bc53ae8b14b7f"
      data-wf-site="62aa7d13e81bc5858eb14b7e">

    <head>
        <meta charset="utf-8" />
        <title>Posted Project Details</title>
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Webflow" name="generator" />
        <link
            href="https://uploads-ssl.webflow.com/62aa7d13e81bc5858eb14b7e/css/huynh-tan-phats-fantabulous-site.webflow.1afd477a4.css"
            rel="stylesheet" type="text/css" />
        <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js" type="text/javascript"></script>
        <script
        type="text/javascript">WebFont.load({google: {families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"]}});</script>
        <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif]-->
        <script
        type="text/javascript">!function (o, c) {
                var n = c.documentElement, t = " w-mod-";
                n.className += t + "js", ("ontouchstart" in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch")
            }(window, document);</script>
        <link href="https://uploads-ssl.webflow.com/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />
        <link href="https://uploads-ssl.webflow.com/62aa7d13e81bc5858eb14b7e/62b0483852fa1b7b5fdeaf3a_internet.png"
              rel="apple-touch-icon" />
    </head>

    <body class="body">
        <%
            HirerDTO loginUser = (HirerDTO) session.getAttribute("USER_LOGIN");
            ProjectDTO currentProject = (ProjectDTO) request.getAttribute("PROJECT_CURRENT");
            List<String> listSkill = (List<String>) request.getAttribute("LIST_SKILL");
            LocalDate localDate = LocalDate.now();

        %>
        <div data-collapse="medium" data-animation="default" data-duration="400" data-easing="ease" data-easing2="ease"
             role="banner" class="navigation-2 seeker w-nav">
            <div class="navigation-container-2">
                <div class="navigation-menu-2"><a href="MainController?action=ViewHirerDashboard" class="brand-2 w-nav-brand"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628aeb849e24d09f04fa55e0_logo.png"
                            loading="lazy" alt="" class="logo-image biglogo" /></a>
                    <div class="nav-search-wrapper-2">
                        <div class="nav-icon-search-2"><img
                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6296b474e000b451cf79e812_search-white.svg"
                                loading="lazy" alt="" /></div>
                        <div class="nav-search-input-2">
                            <div class="w-form">
                                <form id="email-form-2" name="email-form-2" data-name="Email Form 2" method="get"><input
                                        type="text" class="search-input-2 w-input" maxlength="256" name="name-2"
                                        data-name="Name 2" placeholder="" id="name-2" /><input type="submit" value="Submit"
                                        data-wait="Please wait..." class="submit-button-2 w-button" /></form>
                                <div class="w-form-done">
                                    <div>Thank you! Your submission has been received!</div>
                                </div>
                                <div class="w-form-fail">
                                    <div>Oops! Something went wrong while submitting the form.</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="icon-wrapper">
                    <div class="div-block-3">
                        <div data-hover="true" data-delay="0" class="link-4 nav-link w-dropdown">
                            <div class="dropdown-toggle-2 w-dropdown-toggle">
                                <div class="text-block-22">My Job</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="postAJob.jsp"
                                                                            class="dropdown-link-nav w-dropdown-link">Post a Job</a><a href="MainController?action=ViewContractOfHirer"
                                                                            class="dropdown-link-nav w-dropdown-link">All contract</a><a href="#"
                                                                            class="dropdown-link-nav w-dropdown-link">Hire</a></nav>
                        </div>
                        <div data-hover="true" data-delay="0" class="link-4 nav-link w-dropdown">
                            <div class="dropdown-toggle-3 w-dropdown-toggle">
                                <div class="text-block-22">Find Talent</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="#"
                                                                            class="dropdown-moi-qua-troi-moi w-dropdown-link">Find Talent</a></nav>
                        </div>
                    </div><a href="#" class="link-block w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d693684f77e4900d5de82_send.png"
                            loading="lazy" alt="" class="image-15" /></a><a href="#" class="w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d69352ef8ea1801f37308_bell.png"
                            loading="lazy" alt="" /></a>
                    <div class="navigation-button-wrapper">
                        <div data-hover="false" data-delay="0" class="w-dropdown">
                            <div class="dropdown-toggle w-dropdown-toggle"><img
                                    src=<%= loginUser.getAvatar()%>
                                    loading="lazy" width="90" alt="" class="avatar-img-nav" /></div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewHirerProfile"
                                                                            class="dropdown-link w-dropdown-link">My Profile</a>
                                                                        <a href="MainController?action=ViewBalanceHirerSeeker"
                                                                            class="dropdown-link w-dropdown-link">Balance</a>
                                                                        <a href="MainController?action=Logout"
                                                                            class="dropdown-link w-dropdown-link">Log out</a></nav>
                        </div>
                    </div>
                </div>
                <div class="menu-button w-nav-button">
                    <div class="w-icon-nav-menu"></div>
                </div>
            </div>
        </div>
        <div class="w-container">
            <div class="div-block-2">
                <h2 class="heading-4"><%= currentProject.getProjectName()%> </h2>
            </div>
            <div data-current="Tab 2" data-easing="ease" data-duration-in="300" data-duration-out="100" class="w-tabs">
                <div class="tabs-menu w-tab-menu"><a data-w-tab="Tab 1" class="tab-link-tab-1 w-inline-block w-tab-link">
                        <div class="text-block-25">JOB DETAILS</div>
                    </a><a data-w-tab="Tab 2" class="tab-link-tab-2 w-inline-block w-tab-link w--current">
                        <div class="text-block-24">INVITED LIST</div>
                    </a><a data-w-tab="Tab 3" class="tab-link-tab-3 w-inline-block w-tab-link">
                        <div class="text-block-27">PROPOSAL LIST</div>
                    </a></div>
                <div class="tabs-content w-tab-content">
                    <div data-w-tab="Tab 1" class="tab-pane-tab-1 w-tab-pane">
                        <div class="div-block-30">
                            <div class="div-block-31">
                                <h3 class="heading-10"><%= currentProject.getProjectName()%></h3>
                                <div class="text-block-34">Posted <%= localDate.getDayOfYear() - currentProject.getCreatedDate().getDayOfYear()%> days ago</div>
                                <div class="text-block-34"><%= currentProject.getLocation()%></div>
                                <div class="div-block-34">
                                    <div class="div-block-35">
                                        <div class="div-block-39">
                                            <div class="text-block-38"><strong class="bold-text-2"><%= currentProject.getHoursPerWeek()%> Hours Per Weeks</strong>
                                            </div>
                                        </div>
                                        <div class="div-block-39">Hourly</div>
                                    </div>
                                    <div class="div-block-36">
                                        <div class="div-block-39"><strong class="bold-text-3"><%= currentProject.getDurationText()%></strong>
                                        </div>
                                        <div class="div-block-39">Project Length</div>
                                    </div>
                                    <div class="div-block-37">
                                        <div class="div-block-39"><strong><%= currentProject.getComplexity()%> Level</strong></div>
                                        <div class="div-block-39">Understanding</div>
                                    </div>
                                    <div class="div-block-38">
                                        <div class="div-block-39"><strong class="bold-text-4"><%= currentProject.getPaymentAmount()%>$</strong></div>
                                        <div class="div-block-39">Budget</div>
                                    </div>
                                </div>
                                <div class="div-block-42">
                                    <p class="paragraph-2"><%= currentProject.getDescription()%></p>
                                </div>
                                <h4 class="heading-11">Skill and Expertise</h4>
                                <div class="div-block-40">
                                    <div class="list-skill-copy">
                                        <!-- 1 skill -->
                                        <%
                                            for (String skill : currentProject.getSkillneed()) {
                                        %>
                                        <div class="skill-wrapper">
                                            <div class="text-block-26"><%= skill%></div>
                                        </div>
                                        <div style="width: 10px">
                                        </div>


                                        <%
                                            }
                                        %>
                                    </div>
                                </div>
                            </div>
                            <div class="div-block-32">
                                <div class="div-block-33"><a href="MainController?action=EditJobPost&projectID=<%= currentProject.getProjectID() %>" class="link-6">Edit Posting</a><a
                                        data-w-id="d246fcf1-5912-f9e7-80d0-1d8cc603abfe" href="#" class="link-6">Delete
                                        Posting</a></div>
                                <div class="div-block-41">
                                    <h4 class="heading-12">About the Client</h4>
                                    <div class="text-block-39"><strong>Company: <%= loginUser.getCompanyName()%></strong></div>
                                    <div class="text-block-39-copy"><%= loginUser.getLocation()%></div>
                                    <div class="text-block-39"><strong><%= loginUser.getJobPosted()%> jobs posted</strong></div>
                                    <div class="text-block-39-copy">The total number of Job Posted</div>
                                    <div class="text-block-39">Member Since <%= loginUser.getRegistrationDate()%></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div data-w-tab="Tab 2" class="tab-pane-tab-2 w-tab-pane w--tab-active">
                        <div class="proposals">
                            <div class="title">
                                <h3 class="heading-3">Invited Seeker List</h3>
                            </div>
                            <div class="proposals-info">
                                <p class="intro">This is the list of invited freelancer, please waiting for their
                                    responding!</p>
                            </div>
                            <div class="div-block-43">
                                <div class="text-block-40">There is no proposal applied to this project. Do you want to
                                    invite some freelancer? </div><a href="#" class="button-2 w-button">Invite
                                    Freelancer</a>
                            </div>
                            <div class="proposal">
                                <div class="left-proposal">
                                    <div class="image-container"><img
                                            src="https://uploads-ssl.webflow.com/62aa7d13e81bc5858eb14b7e/62ad1a2fb91b813d9e9d488e_thinking.png"
                                            loading="lazy" alt="" class="image-3" /></div>
                                </div>
                                <div class="right-proposal">
                                    <div class="top">
                                        <div class="left">
                                            <div style="display:none;opacity:0" class="div-block-5-copy">
                                                <div class="div-block-6">
                                                    <div class="div-block-7-copy"><img
                                                            src="https://uploads-ssl.webflow.com/62aa7d13e81bc5858eb14b7e/62acb162c92e1de3b5c4368c_Untitled1.png"
                                                            loading="lazy" data-w-id="62bffb8e-5c47-477e-7482-8d4c36a1d58b"
                                                            alt="" class="image-16" /></div>
                                                    <div class="div-block-8"></div>
                                                    <div class="div-block-12">
                                                        <div class="div-block-13">
                                                            <div class="div-block-14">
                                                                <div class="div-block-15"><img
                                                                        src="https://uploads-ssl.webflow.com/62aa7d13e81bc5858eb14b7e/62ad1a2fb91b813d9e9d488e_thinking.png"
                                                                        loading="lazy" alt="" class="image-18" /></div>
                                                                <div class="div-block-16">
                                                                    <h3 class="heading-6">Phat H.</h3>
                                                                    <div>Singapore</div>
                                                                </div>
                                                                <div class="div-block-17"><a href="#"
                                                                                             class="button w-button">Uninvite</a></div>
                                                            </div>
                                                            <div class="div-block-18">
                                                                <div class="div-block-19">
                                                                    <p class="paragraph"><strong>Invited
                                                                            List:<br /></strong>List Seeker that you invited
                                                                        to your Project</p>
                                                                    <p class="paragraph"><strong>Grades:<br /></strong>5/5
                                                                        stars rating</p>
                                                                    <p class="paragraph"><strong>Total
                                                                            Jobs:<br /></strong>123 jobs</p>
                                                                    <p class="paragraph">
                                                                        <strong>Language:<br />‍</strong>English: Basic</p>
                                                                    <p class="paragraph">
                                                                        <strong>Education:<br />‍</strong>FPT
                                                                        University<br />University, Software Engineering</p>
                                                                </div>
                                                                <div class="div-block-20">
                                                                    <div class="div-block-21">
                                                                        <div class="div-block-22">
                                                                            <h4 class="heading-7">Full Stack Developer</h4>
                                                                        </div>
                                                                        <div class="div-block-23">
                                                                            <div class="text-block-31">1000$/hr</div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="div-block-24">
                                                                        <h5 class="heading-8">Overview:</h5>
                                                                        <div class="text-block-32">chung toi chinh lajlga
                                                                            gnag ag jalgjla ga ga galg ag ag ag algdjf dlfg
                                                                            fg al gal ga g fadf aldjg lagj ajg la gadg ladlg
                                                                            aga ;jdgl algj aleg lagj alsdgjl</div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <h4 data-w-id="b1f33dcd-75a7-140e-4edf-099a7e03cf9f" class="name"><a href="#"
                                                                                                                 class="link-5"><span class="text-span-4-copy">Phat H.</span></a></h4>
                                            <div class="major">Full Stack Development | Front-end Dev (major)</div>
                                            <div class="location"><span class="text-span-3">Singapore (location)</span>
                                            </div>
                                            <div class="payment-amount-and-rating">
                                                <div class="payment-and-rating">
                                                    <div>100$/hours (money/hours)</div>
                                                </div>
                                                <div class="payment-and-rating">
                                                    <div>4/5 <strong>☆</strong></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="right"><a href="#" class="hire-button w-button">Uninvite</a></div>
                                    </div>
                                    <div class="down">
                                        <div class="cover-letter-wrapper">
                                            <p class="cover-letter">Over Viewr: Lorem ipsum dolor sit amet, consectetur
                                                adipiscing elit. Suspendisse varius enim in eros elementum tristique. Duis
                                                cursus, mi quis viverra ornare, eros dolor gag a a ... (overview - chỗ này
                                                giới hạn kí tự hiển thị)</p>
                                        </div>
                                        <div class="list-skill">
                                            <div class="skill-wrapper">
                                                <div class="text-block-26">HTML</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div data-w-tab="Tab 3" class="tab-pane-tab-3 w-tab-pane">
                        <div class="proposals">
                            <div class="title">
                                <h3 class="heading-3">Review Proposals</h3>
                            </div>
                            <div class="proposals-info">
                                <p class="intro">This is the list of Proposal that freelancer send to you, check the list
                                    and approve what proposal you like!</p>
                            </div>
                            <%
                                List<ProposalDTO> listAppliedProposal = (List<ProposalDTO>) request.getAttribute("LIST_APPLY_SEEKER");
                                if (listAppliedProposal != null) {
                                    if (listAppliedProposal.size() > 0) {
                                        for (ProposalDTO proposal : listAppliedProposal) {

                            %>
                            <div class="proposal">
                                <div class="left-proposal">
                                    <div class="image-container"><img
                                            src=<%= proposal.getSeeker().getAvatar() %>
                                            loading="lazy" alt="" class="image-3" /></div>
                                </div>
                                <div class="right-proposal">
                                    <div class="top">
                                        <div class="left">
                                            <!-- 1cai proposal detail-->
                                            <div style="display:none;opacity:0" class="div-block-5">
                                                <div class="div-block-6">
                                                    <div data-w-id="35f16084-260c-5d74-45d9-6d48f0351551"
                                                         class="div-block-7"><img
                                                            src="https://uploads-ssl.webflow.com/62aa7d13e81bc5858eb14b7e/62acb162c92e1de3b5c4368c_Untitled1.png"
                                                            loading="lazy" alt="" class="image-16" /></div>
                                                    <div class="div-block-8"></div>
                                                    <div class="div-block-12">
                                                        <div class="div-block-13">
                                                            <div class="div-block-14">
                                                                <div class="div-block-15"><img
                                                                        src=<%= proposal.getSeeker().getAvatar() %>
                                                                        loading="lazy" alt="" class="image-18" /></div>
                                                                <div class="div-block-16">
                                                                    <h3 class="heading-6"><%= proposal.getSeeker().getFullName() %></h3>
                                                                    <div>Singapore</div>
                                                                </div>
                                                                <div class="div-block-17"><a href="MainController?action=ConfirmContract&proposalID=<%=proposal.getProposalID()%>&projectID=<%=currentProject.getProjectID()%>"
                                                                                             class="button w-button">Hirer Feelancer</a></div>
                                                            </div>
                                                            <div class="div-block-18">
                                                                <div class="div-block-19">
                                                                    <p class="paragraph">
                                                                        <strong>Applicant:<br /></strong>Seeker has applied
                                                                        to or been invited to your or your company&#x27;s
                                                                        job </p>
                                                                    <p class="paragraph"><strong>Grades:<br /></strong><%= proposal.getSeeker().getReviewGrade() %>/5
                                                                        stars rating</p>
                                                                </div>
                                                                <div class="div-block-20">
                                                                    <div class="div-block-21">
                                                                        <div class="div-block-22">
                                                                            <h4 class="heading-7">Proposal Details</h4>
                                                                        </div>
                                                                        <div class="div-block-23">
                                                                            <div class="text-block-31"><%= proposal.getPaymentAmount() %>$</div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="div-block-24">
                                                                        <h5 class="heading-8">Cover Letter:</h5>
                                                                        <div class="text-block-32"><%= proposal.getCoverLetter() %></div>
                                                                        <h5 class="heading-8">Attachment:</h5><a href="#"
                                                                                                                  class="link-7"><%= proposal.getAttachment() %></a>
                                                                        <h5 class="heading-8">Expected Duration:</h5>
                                                                        <div class="text-block-33"><%= proposal.getDurationText() %></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                                                    
                                            <!-- end 1 cai proposal detail-->

                                            <h4 data-w-id="537246b1-c851-48fc-e980-8c9df6bac420" class="name"><a href="#"
                                                                                                                 class="link-5"><span class="text-span-4"><%= proposal.getSeeker().getFullName() %></span></a></h4>
                                            <div class="major"><%= proposal.getSeeker().getMajor() %></div>
                                            <div class="location"><span class="text-span-3"><%= proposal.getSeeker().getLocation() %></span></div>
                                            <div class="payment-amount-and-rating">
                                                <div class="payment-and-rating">
                                                    <div><%= proposal.getPaymentAmount() %>$</div>
                                                </div>
                                                <div class="payment-and-rating">
                                                    <div><%= proposal.getSeeker().getReviewGrade() %>/5 <strong>☆</strong></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="right"><a href="MainController?action=ConfirmContract&proposalID=<%= proposal.getProposalID() %>&projectID=<%= currentProject.getProjectID() %>" class="hire-button w-button">Hire</a></div>
                                    </div>
                                    <div class="down">
                                        <div class="cover-letter-wrapper">
                                            <p class="cover-letter"><%= proposal.getCoverLetter() %></p>
                                        </div>
                                        <div class="list-skill">
                                            
                                            <%
                                                for (String skill : proposal.getSeeker().getListSkill()) {
                                            %> 
                                            <div class="skill-wrapper">
                                                <div class="text-block-26"><%= skill%></div>
                                            </div>
                                            <div style="width: 10px">
                                            </div>
                                            <%
                                                }
                                            %>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                            <!-- het 1 cai proposal -->
                            <%   
                                        }
                                    } else { %>
                            <!-- comment -->
                            <div class="div-block-43">
                                <div class="text-block-40">There is no proposal applied to this project. Do you want to
                                    invite some freelancer? </div><a href="#" class="button-2 w-button">Invite
                                    Freelancer</a>
                            </div>
                            <!-- comment -->
                            <%
                                    } 
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="display:none;opacity:0" class="div-block-44">
            <div class="div-block-45">
                <div class="div-block-46">
                    <div class="text-block-44">Are you sure to delete this project ?</div>
                </div>
                <div class="div-block-48">
                    <div class="div-block-47"><a href="MainController?action=RemoveProject&projectID=<%= currentProject.getProjectID() %>" class="button-3 w-button">Yes</a></div>
                    <div class="div-block-49"><a data-w-id="3cd1ff36-3a77-a40f-b032-e2c2ef15d08e" href="#"
                                                 class="button-4 w-button">No</a></div>
                </div>
            </div>
        </div>
        <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62aa7d13e81bc5858eb14b7e"
                type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
        <script src="https://uploads-ssl.webflow.com/62aa7d13e81bc5858eb14b7e/js/webflow.a3c3de4d5.js"
        type="text/javascript"></script>
        <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
    </body>

</html>