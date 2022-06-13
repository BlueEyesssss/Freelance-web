
<%@page import="sample.proposal.ProposalDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.project.ProjectDTO"%>
<!DOCTYPE html>
<html data-wf-domain="proposal-detail.webflow.io" data-wf-page="629c424355a84f54beb5f94c"
    data-wf-site="629c424355a84f5cdfb5f94b">

<head>
    <meta charset="utf-8" />
    <title>Submit Proposal detail</title>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="Webflow" name="generator" />
    <style type="text/css">
        #fixchange{
            width: 60%;
        }
    </style>
    <link href="https://uploads-ssl.webflow.com/629c424355a84f5cdfb5f94b/css/proposal-detail.webflow.b50ccd48d.css"
        rel="stylesheet" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js" type="text/javascript"></script>
    <script
        type="text/javascript">WebFont.load({ google: { families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"] } });</script>
    <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif]-->
    <script
        type="text/javascript">!function (o, c) { var n = c.documentElement, t = " w-mod-"; n.className += t + "js", ("ontouchstart" in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch") }(window, document);</script>
    <link href="https://uploads-ssl.webflow.com/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <link href="https://uploads-ssl.webflow.com/img/webclip.png" rel="apple-touch-icon" />
</head>

<body class="body">
    <%
                    ProjectDTO project = (ProjectDTO)session.getAttribute("PROJECT_DETAIL");
                    List<String> listSkill = (List<String>)session.getAttribute("SKILL_PROJECT_NEED");
                    ProposalDTO proposalINf = (ProposalDTO)session.getAttribute("PROPOSAL_PAYMENT_DURATION");
                %>
    <div data-collapse="medium" data-animation="default" data-duration="400" data-easing="ease" data-easing2="ease"
        role="banner" class="navigation-2 seeker w-nav">
        <div class="navigation-container-2">
            <div class="navigation-menu-2"><a href="MainController?action=ViewSeekerDashboard" class="brand-2 w-nav-brand"><img
                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628aeb849e24d09f04fa55e0_logo.png"
                        loading="lazy" alt="" class="logo-image biglogo" /></a>
                <div class="nav-search-wrapper-2">
                    <div class="nav-icon-search-2"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6296b474e000b451cf79e812_search-white.svg"
                            loading="lazy" alt="" /></div>
                    <div class="nav-search-input-2">
                        <div class="w-form">
                            <form id="email-form-2" name="email-form-2" data-name="Email Form 2" method="get"><input
                                    type="text" class="search-input-2 w-input" maxlength="256" name="name"
                                    data-name="Name" placeholder="" id="name" /><input type="submit" value="Submit"
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
                            <div class="text-block-22">Find Work</div>
                        </div>
                        <nav class="dropdown-list-2 w-dropdown-list">
                            <a href="MainController?action=ViewSeekerDashboard"
                                class="dropdown-link-nav w-dropdown-link">Find Work</a>
                                <a href="#"
                                class="dropdown-link-nav w-dropdown-link">Save Jobs</a>
                                <a href="MainController?action=ViewProposal"
                                class="dropdown-link-nav w-dropdown-link">Proposals</a>
                        </nav>
                    </div>
                    <div data-hover="true" data-delay="0" class="link-4 nav-link w-dropdown">
                        <div class="dropdown-toggle-3 w-dropdown-toggle">
                            <div class="text-block-22">My Job</div>
                        </div>
                        <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewMyJob"
                                class="dropdown-link-nav w-dropdown-link">My Job</a><a href="MainController?action=ViewContract"
                                class="dropdown-link-nav w-dropdown-link">All Constract</a></nav>
                    </div>
                </div><a href="#" class="link-block w-inline-block"><img
                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d693684f77e4900d5de82_send.png"
                        loading="lazy" alt="" class="image-15" /></a><a href="#" class="w-inline-block"><img
                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d69352ef8ea1801f37308_bell.png"
                        loading="lazy" alt="" /></a>
                <div class="navigation-button-wrapper">
                    <div data-hover="false" data-delay="0" class="w-dropdown">
                        <div class="dropdown-toggle w-dropdown-toggle"><img
                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n.jpeg"
                                loading="lazy" width="90" alt="" class="avatar-img-nav" /></div>
                        <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewSeekerProfile"
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
    <div class="w-container">
        <div class="proposal-detail">Proposal details</div>
    </div>
    <div class="proposal-detail-wrapped w-container">
        <div class="proposal-text">
            <div class="div-block">
                <div class="job-details-wrapper">
                    <div class="job-details-text">
                        <div class="job-details">Job details</div>
                    </div>
                </div>
                <div class="div-block-2">
                    <div class="looking-for-details">
                        <div class="java-backend-wrapper">
                            <div class="java-backend"><%= project.getProjectName() %></div>
                        </div>
                        <div class="backend-dev-wrapper">
                            <div class="backend-dev">
                                <div class="backend-dev-text"><%= project.getMajor()%></div>
                            </div>
                            <div class="posted">
                                <div class="post-time">Posted <%= project.getCreatedDate()%></div>
                            </div>
                        </div>
                        <div class="description">
                            <div class="description-text"><%= project.getDescription()%>.</div>
                        </div>
                    </div>
                    <div class="intermediate">
                        <div>
                            <div class="intermediate-wrapper"><strong class="intermediate">About <%= project.getHoursPerWeek()%> hours/week</strong></div>
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
                            for (String elem : listSkill) {
                                    %>
                                    <div class="java"><%= elem %></div>
                        <%
                                }
                        %>
                    </div>
                </div>
                <div class="job-term">
                    <div class="proposal-term">
                        <div class="your-proposed-terms-wrapper">
                            <div class="your-proposed-terms">Your proposed terms<br /></div>
                        </div>
                        <div class="total-price-wrapper">
                            <div class="total-price">Total price of project<p>~</p></div>
                            
                            <div>
                                <div class="include">This includes all milestones, and is the amount your client will
                                    see.</div>
                            </div>
                            <div>
                                <div class="money">$<%= proposalINf.getPaymentAmount() %></div>
                            </div>
                            <div class="text-block-53">Expected duration: <%= proposalINf.getDurationText()%></div>
                        </div>
                    </div>
                    <div class="budget">
                        <div class="client-s-budget-wrapper">
                            <div class="client-s-budget"></div>
                        </div>
                    </div>
                </div>
                <div data-w-id="d7569efe-aa7d-e650-cf00-40a1b84a7480" class="div-block-19" >
                    <div class="change-term-button-wrapper" ><a href="#" class="button-term w-button" id="fixchange">Accept </a>
                    </div>
                    <div><a href="#" data-w-id="d7569efe-aa7d-e650-cf00-40a1b84a7485" class="button-5 w-button">Reject</a></div>
                </div>
                
            </div>
        </div>
    </div>
    <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=629c424355a84f5cdfb5f94b"
        type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
    <script src="https://uploads-ssl.webflow.com/629c424355a84f5cdfb5f94b/js/webflow.846169434.js"
        type="text/javascript"></script>
    <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>

</html>