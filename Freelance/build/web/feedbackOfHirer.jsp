<%@page import="sample.hirer.HirerDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.project.ProjectDAO"%>
<%@page import="sample.project.ProjectDTO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="sample.proposal.ProposalDTO"%>
<!DOCTYPE html>
<html data-wf-domain="feedback-for-hirer.webflow.io" data-wf-page="62c2ed5bd85e4933a15d234e"
    data-wf-site="62c2ed5bd85e4981bd5d234d">

<head>
    <meta charset="utf-8" />
    <title>feedback for hirer</title>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="Webflow" name="generator" />
    <link href="https://uploads-ssl.webflow.com/62c2ed5bd85e4981bd5d234d/css/feedback-for-hirer.webflow.b88abd168.css"
        rel="stylesheet" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js" type="text/javascript"></script>
    <script
        type="text/javascript">WebFont.load({ google: { families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"] } });</script>
    <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif]-->
    <script
        type="text/javascript">!function (o, c) { var n = c.documentElement, t = " w-mod-"; n.className += t + "js", ("ontouchstart" in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch") }(window, document);</script>
    <link href="https://uploads-ssl.webflow.com/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <link href="https://uploads-ssl.webflow.com/img/webclip.png" rel="apple-touch-icon" />
    <style>
        .w-webflow-badge {
            display: none !important;
        }
    </style>
</head>
<%
    HirerDTO loginUser = (HirerDTO) session.getAttribute("USER_LOGIN");
    ProposalDTO proposal = (ProposalDTO)request.getAttribute("PROPOSAL");
    ProjectDAO dao = new ProjectDAO();
    ProjectDTO project = dao.getProjectByID(proposal.getProjectID());
    List<String> skillneed = dao.getSkillNeedOfProject(project.getProjectID());
                    project.setSkillneed(skillneed);
    if(proposal!= null){
        %>
<body>
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
                <div>
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
                        <nav class="dropdown-list-2 w-dropdown-list"></nav>
                    </div>
                </div><a href="#" class="link-block w-inline-block"><img
                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d693684f77e4900d5de82_send.png"
                        loading="lazy" alt="" class="image-15" /></a><a href="#" class="w-inline-block"><img
                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d69352ef8ea1801f37308_bell.png"
                        loading="lazy" alt="" /></a>
                <div class="navigation-button-wrapper">
                    <div data-hover="false" data-delay="0" class="w-dropdown">
                        <div class="dropdown-toggle w-dropdown-toggle"><img
                                src="uploads/<%= loginUser.getAvatar() %>"
                                loading="lazy" width="90" alt="" class="avatar-img-nav" /></div>
                        <nav class="dropdown-list-2 w-dropdown-list">
                        <a href="MainController?action=ViewHirerProfile"
                                class="dropdown-link w-dropdown-link">My Profile</a>
                            <a href="MainController?action=ViewBalanceHirerSeeker"
                                class="dropdown-link w-dropdown-link">Balance</a>
                            <a href="MainController?action=Logout"
                                class="dropdown-link w-dropdown-link">Log out</a>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="menu-button w-nav-button">
                <div class="w-icon-nav-menu"></div>
            </div>
        </div>
    </div>
    <div class="container-4 w-container">
        <div class="proposal-detail-3">Proposal details</div>
    </div>
    <div class="proposal-detail-wrapped w-container">
        <div class="proposal-text">
            <div class="div-block">
                <div class="job-details-wrapper-2">
                    <div class="job-details-text">
                        <div class="job-details">Job details</div>
                    </div>
                </div>
                <div class="div-block-2">
                    <div class="looking-for-details">
                        <div class="java-backend-wrapper">
                            <div class="java-backend-2"><%= project.getProjectName()%></div>
                        </div>
                        <div class="backend-dev-wrapper">
                            <div class="backend-dev">
                                <div class="backend-dev-text"><%= project.getMajor()%></div>
                            </div>
                            <div class="posted-2">
                                <div class="post-time">Posted <%= project.getCreatedDate()%></div>
                            </div>
                        </div>
                        <div class="description">
                            <div class="description-text"><%= project.getDescription()%></div>
                        </div>
                    </div>
                    <div class="intermediate-2">
                        <div>
                            <div class="intermediate-wrapper"><strong class="intermediate-2"><%= project.getHoursPerWeek()%> hours/week</strong></div>
                        </div>
                        <div class="experience-wrapper">
                            <div class="experience">Hourly</div>
                        </div>
                        <div class="_1-to-3-months-wrapper">
                            <div class="_1-to-3-months"><strong><%= project.getDurationText()%></strong></div>
                        </div>
                        <div class="project-length-wrapper">
                            <div class="project-length">Project Length</div>
                            <div class="_1-to-3-months"><strong><%= project.getComplexity()%></strong></div>
                        </div>
                        <div class="project-length">I am looking for mix of experience<br />and value</div>
                        <div class="_1-to-3-months"><strong><%= project.getPaymentAmount()%> $</strong></div>
                        <div class="project-length">Budget</div>
                    </div>
                </div>
                <div class="div-block-3">
                    <div class="skills-and-expertise-wrapper">
                        <div class="skills-and-expertise">Skills and expertise</div>
                    </div>
                    <div class="java-wrapper">
                        <%
                                                    for (String skill : project.getSkillneed()) {
                                                %>
                        <div class="java"><%= skill %></div>
                        <%
                                                    }
                                                %>
                    </div>
                </div>
                <div class="job-term-3">
                    <div class="proposal-term">
                        <div class="your-proposed-terms-wrapper">
                            <div class="your-proposed-terms">Your proposed terms<br /></div>
                        </div>
                        <div class="total-price-wrapper-2">
                            <div class="total-price-2">Total price of project</div>
                            <div>
                                <div class="include-2">This includes all milestones, and is the amount your client will
                                    see.</div>
                            </div>
                            <div>
                                <div class="money">$<%= proposal.getPaymentAmount()%></div>
                            </div>
                            <div class="text-block-54">Expected duration: $<%= proposal.getDurationText()%></div>
                        </div>
                    </div>
                    
                </div>
                <div class="div-block-19">
                    <div data-w-id="8ad3253d-7034-aa90-51f1-bd824323c70b" class="change-term-button-wrapper">
                        <div data-current="Tab 1" data-easing="ease" data-duration-in="300" data-duration-out="100"
                            class="tabs w-tabs">
                            <%
                                LocalDate endDate = (LocalDate)request.getAttribute("END_DATE");
                                boolean checkAlreadlyFeedback =(boolean) request.getAttribute("CHECK_FEEDBACK_ALREADY");
                                String error = (String)request.getAttribute("ERROR_MESSAGE");
                                if(error == null) error ="";
                                LocalDate curent = LocalDate.now();                                
                            if(curent.isBefore(endDate.plusDays(7)) && curent.isAfter(endDate.minusDays(1)) && !checkAlreadlyFeedback){
                                %>
                            <div class="tabs-menu w-tab-menu"><a data-w-tab="Tab 1"
                                    data-w-id="8ad3253d-7034-aa90-51f1-bd824323c70e"
                                    class="feedback-button tabs-menu w-inline-block w-tab-link w--current">
                                    <div class="feedback">Feedback</div>
                                </a></div>
                            <div style="color: orange"><%= error%></div>
                            <div class="tabs-content w-tab-content">
                                <div data-w-tab="Tab 1" class="feedback-tab w-tab-pane w--tab-active">
                                    <div class="feedback-wrapper">
                                        <div class="w-form">
                                            
                                            <form action="MainController" id="email-form-6" name="email-form-6" data-name="Email Form 6"
                                                method="get" class="form"><label for="name"
                                                                             class="field-label-2">Feedback Grade</label><input type="number"
                                                    class="text-field-3 w-input" maxlength="256" name="seekerGrade"
                                                    data-name="Name 2" placeholder="1 to 5" id="name-2" /><label for="field-4"
                                                    class="field-label-3">Comment</label><textarea placeholder=""
                                                    maxlength="5000" id="field-4" name="clientComment" data-name="field"
                                                    class="textarea-2 w-input"></textarea>
                                                    <input type="hidden" name ="proposalID" value="<%=proposal.getProposalID()%>"/>
                                                    <button type="submit" name="action" value="FeedbackOfHirer" class="send-feedback w-button">Send</button>
                                                    
                                                    <a data-w-id="971ae8b1-0d9e-55af-f002-1a17c568fb54" href="#" class="cancel-feedback w-button">Cancel</a>
                                            </form>
                                                    
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
                                                                    <%
                            }
                            %>
                        </div>
                    </div>
                </div>
                <div class="change-term">
                    <div class="milestones-include"></div>
                    <div class="animation-div">
                        <div class="div-wrapper-2">
                            <div class="div-block-16"></div>
                            <div>
                                <div class="text-block-31"><strong class="bold-text-7">What is the full amount
                                        you&#x27;d like to bid for this job?</strong></div>
                            </div>
                            <div class="div-block-7">
                                <div class="bid-wrapper">
                                    <div class="bid">
                                        <div>
                                            <div class="text-block-28">Bid</div>
                                        </div>
                                        <div>
                                            <div class="text-block-29">Total amount the client will see on your proposal
                                            </div>
                                        </div>
                                    </div>
                                    <div class="money-wrapped">
                                        <div class="w-form">
                                            <form id="email-form-3" name="email-form-3" data-name="Email Form 3"
                                                method="get"><input type="text" class="money-inputted w-input"
                                                    maxlength="256" name="field" data-name="Field" placeholder=""
                                                    id="field" required="" /></form>
                                            <div class="w-form-done">
                                                <div>Thank you! Your submission has been received!</div>
                                            </div>
                                            <div class="w-form-fail">
                                                <div>Oops! Something went wrong while submitting the form.</div>
                                            </div>
                                        </div><img
                                            src="https://uploads-ssl.webflow.com/629c424355a84f5cdfb5f94b/629d5ce3e4ddd9049f96a4a7_800px-Dollar_Sign.svg.png"
                                            loading="lazy" width="23" alt="" class="image-17" />
                                    </div>
                                </div>
                            </div>
                            <div class="div-block-9">
                                <div></div>
                                <div class="div-block-14"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62c2ed5bd85e4981bd5d234d"
        type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
    <script src="https://uploads-ssl.webflow.com/62c2ed5bd85e4981bd5d234d/js/webflow.574a4c0ec.js"
        type="text/javascript"></script>
    <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
<%
}
%>
</html>