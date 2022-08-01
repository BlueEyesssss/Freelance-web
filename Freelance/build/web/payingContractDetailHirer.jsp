
<%@page import="java.time.LocalDate"%>
<%@page import="sample.hirer.HirerDTO"%>
<%@page import="sample.proposal.ProposalDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.project.ProjectDTO"%>
<!DOCTYPE html><!-- This site was created in Webflow. https://www.webflow.com -->
<!-- Last Published: Thu Jun 30 2022 19:55:16 GMT+0000 (Coordinated Universal Time) -->
<html data-wf-domain="huynh-tan-phats-continue.webflow.io" data-wf-page="62bdf9a94a3336d92ff4149e"
    data-wf-site="62bdf9a94a3336c64bf4149d">

<head>
    <meta charset="utf-8" />
    <title>Paying Contract</title>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="Webflow" name="generator" />
    <link
        href="https://uploads-ssl.webflow.com/62bdf9a94a3336c64bf4149d/css/huynh-tan-phats-continue.webflow.4f43e6499.css"
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

<body class="body">
    <%              
    HirerDTO loginUser = (HirerDTO) session.getAttribute("USER_LOGIN");
    ProjectDTO project = (ProjectDTO)request.getAttribute("PROJECT_DETAIL");
    List<String> listSkill = (List<String>)request.getAttribute("SKILL_PROJECT_NEED");
    ProposalDTO proposalINf = (ProposalDTO)request.getAttribute("PROPOSAL_PAYMENT_DURATION");
    String attachment = (String) request.getAttribute("ATTACHMENT");
    int seekerID = (int)request.getAttribute("SEEKERID");
    LocalDate localDate = LocalDate.now();
    %>
    <div data-collapse="medium" data-animation="default" data-duration="400" data-easing="ease" data-easing2="ease"
        role="banner" class="navigation-2 seeker w-nav">
        <div class="navigation-container-2">
            <div class="navigation-menu-2"><a href="#" class="brand-2 w-nav-brand"><img
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
                                class="dropdown-link-nav w-dropdown-link">All contract</a></nav>
                    </div>
                    <div data-hover="true" data-delay="0" class="link-4 nav-link w-dropdown">
                        <div class="dropdown-toggle-3 w-dropdown-toggle">
                            <div class="text-block-22"><a href="GetAllSeeker" style="color: white; text-decoration: none">Find Talent</a></div>
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
                        <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewHirerProfile"
                                class="dropdown-link w-dropdown-link">My Profile</a><a href="MainController?action=Logout"
                                class="dropdown-link w-dropdown-link">Log out</a></nav>
                    </div>
                </div>
            </div>
            <div class="menu-button w-nav-button">
                <div class="w-icon-nav-menu"></div>
            </div>
        </div>
    </div>
    <div class="div-block-50-copy">
        <h1 class="heading-13">Paying Contract</h1>
        <div class="div-block-30-copy">
            <div class="div-block-31">
                <h3 class="heading-10"><%= project.getProjectName() %></h3>
                <div class="text-block-34">Posted <%= localDate.getDayOfYear() - project.getCreatedDate().getDayOfYear()%> days ago</div>
                <div class="text-block-34"><%= project.getLocation() %></div>
                <div class="div-block-34">
                    <div class="div-block-35">
                        <div class="div-block-39">
                            <div class="text-block-38"><strong class="bold-text-3"><%= project.getHoursPerWeek() %> Hours per week</strong></div>
                        </div>
                        <div class="div-block-39">Hourly</div>
                    </div>
                    <div class="div-block-35">
                        <div class="div-block-39"><strong class="bold-text-3"><%= project.getDurationText() %></strong></div>
                        <div class="div-block-39">Project Length</div>
                    </div>
                    <div class="div-block-37">
                        <div class="div-block-39"><strong><%= project.getComplexity() %></strong></div>
                        <div class="div-block-39">Understanding</div>
                    </div>
                    <div class="div-block-35">
                        <div class="div-block-39"><strong class="bold-text-3"><%= project.getPaymentAmount() %>$</strong></div>
                        <div class="div-block-39">Budget</div>
                    </div>
                </div>
                <div class="div-block-42">
                    <p class="paragraph-2"><%= project.getDescription() %></p>
                </div>
                <h4 class="heading-11">Skill and Expertise</h4>
                <div class="div-block-40">
                    <div class="list-skill-copy">
                        
                        <%
                            for (String elem : listSkill) {
                                    %>
                        <div class="skill-wrapper">
                            <div class="text-block-26"><%= elem %></div>
                        </div>
                        <div style="width: 10px"></div>
                        <%
                                }
                        %>
                        
                    </div>
                </div>
                <div class="div-block-60">
                    <h4 class="heading-14">Your Proposed Term</h4>
                    <div class="text-block-40">This includes all milestones, and is the amount your client will see.
                    </div>
                    <div><em class="italic-text">Payment Amount:</em> $<%= proposalINf.getPaymentAmount() %>$ .</div>
                    <div class="text-block-43"><em class="italic-text-2">Expected duration:</em> <%= proposalINf.getDurationText()%></div>
                </div>
                <div class="div-block-61">
                    <h4 class="heading-15">The Sumitted Work</h4>
                    <div class="text-block-42"><em style="margin-left: 0px;" class="italic-text-2">Link Work:</em> <%= proposalINf.getLink() %></div>
                    <div class="text-block-41"><em style="margin-left: 0px;" class="italic-text-2">Message:</em> <%= proposalINf.getMessage() %></div>
                    <div class="text-block-41"><em style="margin-left: 0px;" class="italic-text-2">Attached File:</em> <a href="DownloadFileController?fileName=<%= proposalINf.getFileName() %>" style="color: grey;">Download</a></div>

                </div>
            </div>
            <div class="div-block-32">
                <div class="div-block-41">
                    <h4 class="heading-12">About the Client</h4>
                    <div class="text-block-39"><strong>Company: <%= loginUser.getCompanyName() %></strong></div>
                    <div class="text-block-39-copy"><%= loginUser.getLocation() %></div>
                    <div class="text-block-39"><strong><%= loginUser.getJobPosted() %> Jobs Posted</strong></div>
                    <div class="text-block-39-copy">The total number of Job Posted</div>
                    <div class="text-block-39">Member since <%= loginUser.getRegistrationDate() %></div>
                </div>
                <div class="div-block-59"><a href="MainController?action=PayMoney&proposalID=<%= proposalINf.getProposalID() %>" class="button-5-copy w-button">Pay Money</a><a href="MainController?action=ReportSeeker&proposalID=<%= proposalINf.getProposalID() %>"
                        class="button-6-copy w-button">Report Seeker</a></div>
            </div>
        </div>
    </div>
    <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62bdf9a94a3336c64bf4149d"
        type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
    <script src="https://uploads-ssl.webflow.com/62bdf9a94a3336c64bf4149d/js/webflow.2211b37e9.js"
        type="text/javascript"></script>
    <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>

</html>