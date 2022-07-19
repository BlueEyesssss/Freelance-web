<%-- 
    Document   : seekerDashboardTest1
    Created on : Jun 8, 2022, 12:52:24 AM
    Author     : Phat
--%>

<%@page import="sample.hirer.HirerDTO"%>
<%@page import="sample.hirer.HirerDTO"%>
<%@page import="sample.project.ProjectDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="sample.seeker.SeekerDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html data-wf-page="6296b69f7f3f296ebff1f241"
data-wf-site="628aea177e2bdc5cebb3b655" data-wf-status="1">

<head>
    <meta charset="utf-8" />
    <title>Seeker Dashboard</title>
    <meta content="Seeker Dashboard" property="og:title" />
    <meta content="Seeker Dashboard" property="twitter:title" />
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="Webflow" name="generator" />
    <link href="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/css/upwork-7e964a.webflow.870b4ffa2.css"
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
        .w-webflow-badge{
            display: none !important;
        }
    </style>
</head>
<%
        SeekerDTO loginUser = (SeekerDTO) session.getAttribute("USER_LOGIN");
        LocalDate localDate = LocalDate.now();
        String weekday = localDate.getDayOfWeek().name().substring(0, 1) + localDate.getDayOfWeek().name().substring(1).toLowerCase();
        String month = localDate.getMonth().name().substring(0, 1) + localDate.getMonth().name().substring(1).toLowerCase();
        LocalTime localTime = LocalTime.now();
        String hello;
        if (localTime.getHour() >= 6 && localTime.getHour() < 12) {
            hello = "Good Morning";
        } else if (localTime.getHour() >= 12 && localTime.getHour() < 18) {
            hello = "Good Afternoon";
        } else {
            hello = "Good Evening";
        };


    %>

<body class="user-body">
    <div data-collapse="medium" data-animation="default" data-duration="400" data-easing="ease" data-easing2="ease"
        role="banner" class="navigation seeker w-nav">
        <div class="navigation-container">
            <div class="navigation-menu"><a href="#" class="brand w-nav-brand"><img
                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628aeb849e24d09f04fa55e0_logo.png"
                        loading="lazy" alt="" class="logo-image biglogo" /></a>
                <div class="nav-search-wrapper">
                    <div class="nav-icon-search"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6296b474e000b451cf79e812_search-white.svg"
                            loading="lazy" alt="" /></div>
                    <div class="nav-search-input">
                        <div class="w-form">
                            <form action="MainController" id="email-form-2" name="email-form-2" data-name="Email Form 2" method="get"><input
                                        type="text" class="search-input w-input" maxlength="256" name="search"
                                        data-name="Name" placeholder="Find job here" id="name" /><input  type="submit" name="action" value="Search Job By Name" 
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
                    <div data-hover="true" data-delay="0" class="link nav-link w-dropdown">
                        <div class="dropdown-toggle-2 w-dropdown-toggle">
                            <div class="text-block-22">Find Work</div>
                        </div>
                        <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=Search Job By Name&search="
                                                                            class="dropdown-link-nav w-dropdown-link">Find Work</a><a href="MainController?action=ViewProposal"
                                                                            class="dropdown-link-nav w-dropdown-link">Proposals</a></nav>
                    </div>s
                    <div data-hover="true" data-delay="0" class="link nav-link w-dropdown">
                        <div class="dropdown-toggle-3 w-dropdown-toggle">
                            <div class="text-block-22">My Job</div>
                        </div>
                        <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewMyJob"
                                                                            class="dropdown-link-nav w-dropdown-link">My Job</a>
                                                                     <a href="MainController?action=ViewContract"
                                                                            class="dropdown-link-nav w-dropdown-link">All Contracts</a></nav>
                    </div>
                </div><a href="#" class="w-inline-block"><img
                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d693684f77e4900d5de82_send.png"
                        loading="lazy" alt="" class="image-3" /></a><a href="#" class="w-inline-block"><img
                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d69352ef8ea1801f37308_bell.png"
                        loading="lazy" alt="" /></a>
                <div class="navigation-button-wrapper">
                    <div data-hover="false" data-delay="0" class="w-dropdown">
                        <div class="dropdown-toggle w-dropdown-toggle"><img
                                loading="lazy" width="90"
                                sizes="(max-width: 479px) 100vw, (max-width: 767px) 25.4296875px, 6vw"
                                srcset="uploads/<%= loginUser.getAvatar() %>"
                                alt="" class="avatar-img-nav" style="width: 60px; height: 60px"/></div>
                        <nav class="dropdown-list w-dropdown-list">
                            <a href="MainController?action=ViewSeekerProfile" class="dropdown-link w-dropdown-link">My
                                    Profile</a>
                            <a href="MainController?action=ViewBalanceHirerSeeker&role=seeker" class="dropdown-link w-dropdown-link">Balance</a>
                            <a href="MainController?action=Logout" class="dropdown-link w-dropdown-link">Log out</a></nav>
                    </div>
                </div>
            </div>
            <div class="menu-button w-nav-button">
                <div class="w-icon-nav-menu"></div>
            </div>
        </div>
    </div>
    <div class="seeker-main-sec wf-section">
        <div class="container-90 w-container">
            <div class="div-horizon align-start">
                <div class="left-side">
                    <div class="welcome">
                            <div class="text-block-3"><%= weekday%>, <%= month%> <%= localDate.getDayOfMonth()%></div>
                            <h1 class="heading-2"><%= hello%><br /> <%= loginUser.getFullName()%></h1><img
                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d887819668059765d21d0_Charco%20Notifications%20(1).png"
                                loading="lazy" alt="" class="image-4" />
                        </div>
                                
                    <div class="search-seeker">
                        <div class="seeker-main-inputsearch">
                            <div class="form-block-3 w-form">
                                <form action="MainController" id="email-form-3" name="email-form-3" data-name="Email Form 3" method="get"
                                    class="form-4"><input type="text" class="search-input-seeker-dashboard w-input"
                                        maxlength="256" name="search" data-name="Email" placeholder="" id="email"
                                        required="" /><input type="submit" name="action" value="Search Job By Name" value="Submit" data-wait="Please wait..."
                                        class="submit-button-3 w-button" /></form>
                                <div class="w-form-done">
                                    <div>Thank you! Your submission has been received!</div>
                                </div>
                                <div class="w-form-fail">
                                    <div>Oops! Something went wrong while submitting the form.</div>
                                </div>
                            </div>
                        </div>
                        
                        
                        <div class="div-block-24"><img
                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6296b474e000b451cf79e812_search-white.svg"
                                loading="lazy" alt="" /></div>
                    </div>
                    <div class="seeker-main">
                        <h2 class="heading-4">Job you may like</h2>
                        <div data-current="Tab 1" data-easing="ease" data-duration-in="300" data-duration-out="100"
                            class="tabs w-tabs">
                            <div class="tabs-menu w-tab-menu"><a data-w-tab="Tab 1"
                                    class="tab-link-tab-1 w-inline-block w-tab-link w--current">
                                    <div class="tab-text">Best match</div>
                                </a><a data-w-tab="Tab 2" class="tab-link-tab-2 w-inline-block w-tab-link">
                                    <div class="tab-text">All the jobs</div>
                                </a><a data-w-tab="Tab 3" class="tab-link-tab-3 w-inline-block w-tab-link">
                                    <div class="tab-text">Saved jobs</div>
                                </a></div>
                            <div class="w-tab-content">
                                <div data-w-tab="Tab 1" class="w-tab-pane w--tab-active">
                                    <div class="text-block-5">Browse jobs that match your experience to a client&#x27;s
                                        hiring preferences.<br />Ordered by most relevant.</div>
                                    <div class="seeker-dividen"></div>
                       
                                     <%   
                                                                                     List<HirerDTO> listHirer = (List<HirerDTO>) session.getAttribute("LIST_HIRER");

                                         List<ProjectDTO> listBestMatchProject = (List<ProjectDTO>) request.getAttribute("LIST_BEST_MATCH_PROJECT");
                                            if (listBestMatchProject != null) {
                                                if (listBestMatchProject.size() > 0) {
                                                    for (ProjectDTO project : listBestMatchProject) {
                                                    
                                        %>
                                        
                                        <%                          
                                            

                                                                    HirerDTO hirer = null;
                                                                    for (HirerDTO elem : listHirer) {
                                                                        if (elem.getHirerID() == project.getHirerID()) {
                                                                            hirer = elem;
                                                                        }
                                                                    }
                                                        %>  
                                        
                                    <div class="joblist-wrapper"><a href="#" class="click-link w-inline-block">
                                            <h3 class="heading-13"> <%= project.getProjectName()%> </h3>
                                            </a>
                                            <div>Price: <%= project.getPaymentAmount()%> - <%= project.getComplexity()%> - Post <%= localDate.getDayOfYear() - project.getCreatedDate().getDayOfYear() %> days Ago</div>
                                            <p class="paragraph"> <%= project.getDescription()%></p>
                                            <div class="div-block-7"><img loading="lazy"
                                                                          src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d915178de70c73cbd8e23_star.png"
                                                                          alt="" />
                                                <div> <%= hirer.getReviewGrade() %>/5 points</div>
                                            </div>
                                            
                                        <div class="seeker-skill-wrapper">
                                                <%
                                                    for (String skill : project.getSkillneed()) {
                                                %>
                                                <div class="seeker-skill"><%= skill %></div>
                                                <%
                                                    }
                                                %>
                                           
                                        </div>
                                            
                                        <div class="seeker-dividen"></div>
                                        <div class="lightbox-project-detail">
                                            <div data-w-id="9066dcf3-f84c-cbf2-e3fb-4d1d61584a24" class="close-div">
                                            </div>
                                            <div class="light-box-job-content">
                                                <div class="div-block-16"><img width="46" loading="lazy"
                                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6294321c437de4e9e1dfbcef_chevron-left.svg"
                                                        alt="" class="image-11" /></div>
                                                <div class="lb-jobdetail-wrapper">
                                                    <div class="lb-jobdetail-left">
                                                        <div class="lb-jobdetail-div">
                                                            <h1 class="heading-10"><%= project.getProjectName()%></h1>
                                                        </div>
                                                        <div class="lb-jobdetail-div">
                                                            <div class="lb-heading-text"><%= project.getMajor()%></div>
                                                            <div class="lb-text head">Post <%= localDate.getDayOfYear() - project.getCreatedDate().getDayOfYear() %> Days Ago</div>
                                                            <div class="lb-location-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629436cf2d0c464f33b2ff23_map-pin.svg"
                                                                    alt="" class="image-7" />
                                                                <div> <%= project.getLocation() %></div>
                                                            </div>
                                                        </div>
                                                        <div class="lb-jobdetail-div">
                                                            <div class="lb-text"><%= project.getDescription() %><br /></div>
                                                        </div>
                                                        <div class="lb-jobdetail-div horizontal">
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6294856546d2658dc08ad6f0_clock.png"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div class="text-block-16"><strong
                                                                            class="lb-condition-bold-text"><%= project.getHoursPerWeek()%> Hours</strong></div>
                                                                    <div class="lb-small-text">Hourly</div>
                                                                </div>
                                                            </div>
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62948564b5cf0e21235cdf86_calendar.png"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div><strong class="lb-condition-bold-text"><%= project.getExpectedDurationID()%></strong></div>
                                                                    <div class="text-block-14">Project Length</div>
                                                                </div>
                                                            </div>
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629485637925c58b3f06f159_mdi_head-cog.svg"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div class="lb-condition-bold-text"><strong
                                                                            class="bold-text"><%= project.getComplexity()%></strong>
                                                                    </div>
                                                                    <div class="text-block-12">Understanding of Major</div>
                                                                </div>
                                                            </div>
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629423f2cd8d721f22e4bafb_moeny.png"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div class="lb-condition-bold-text">
                                                                        <strong><%= project.getPaymentAmount()%>$</strong></div>
                                                                    <div class="text-block-12">Budget</div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                                                                                    <div class="lb-jobdetail-div">
                                                                <div class="lb-heading-text">Skill and Expertise</div>
                                                                <%
                                                                    for (String skill : project.getSkillneed()) {
                                                                %>
                                                                <div class="expected-skill"><%= skill%></div>
                                                                <%
                                                                    }
                                                                %>
                                                            </div>
                                                    </div>
                                                    <div class="lb-jobdetail-right">
                                                        <div class="lb-joblist-button-wrapper"><a href="MainController?action=FormSentProposal&projectID=<%= project.getProjectID()%>"
                                                                class="primary-button w-button">Submit a proposal</a><a
                                                                href="MainController?action=CreateFavoriteProject&projectID=<%= project.getProjectID()%>" class="primary-button sub w-button"> ♡ Save
                                                                job</a><a href="#"
                                                                class="lb-flag-wrapper w-inline-block"><img
                                                                    loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62948a9d2d0c46f777b5b766_flag.svg"
                                                                    alt="" class="image-9" />
                                                                <div class="text-block-17">Flag as inappropriate</div>
                                                            </a>
                                                            <div class="lb-text">Feel free to approach</div>
                                                        </div>
                                                        <div class="dividen"></div>
                                                        
                                                                   
                                                        
                                                        <div class="lb-about-client-wrapper">
                                                            <h3 class="heading-11">About client</h3>
                                                            <div class="lb-review-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d915178de70c73cbd8e23_star.png"
                                                                    alt="" class="image-10" />
                                                                <div class="lb-review-text"><%= hirer.getReviewGrade() %> Stars <br />of 999
                                                                    reviews</div>
                                                            </div>
                                                            <div class="lb-left-element-wrapper">
                                                                <h4 class="heading-12">Company: <%= hirer.getCompanyName() %></h4>
                                                                <div><%= hirer.getLocation() %></div>
                                                            </div>
                                                            <div class="lb-left-element-wrapper">
                                                                <h4 class="heading-12"><%= hirer.getJobPosted() %> Job Posted</h4>
                                                                <div>The total number of posted job</div>
                                                            </div>
                                                            <div class="lb-left-element-wrapper">
                                                                <h4 class="heading-12">$100k+ total spent</h4>
                                                                <div>90 hires, 12 active - cho nay chua lam</div>
                                                            </div>
                                                            <div>Member since <%= hirer.getRegistrationDate() %></div>
                                                        </div>
                                                         
                                                                    
                                                              
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                                                    
                                        <%
                                                    }
                                                }
                                            }
                                        %>
                                </div>
                                <div data-w-tab="Tab 2" class="w-tab-pane">
                                    <div class="text-block-5">Browse jobs that match your experience to a client&#x27;s
                                        hiring preferences.<br />Ordered by most relevant.</div>
                                    <div class="seeker-dividen"></div>
                                    
                                    
                                    
                                    
                                    
                                    <%  int count = 0;          
                                        List<ProjectDTO> listAllProject = (List<ProjectDTO>) request.getAttribute("LIST_ALL_PROJECT");
                                            if (listAllProject != null) {
                                                if (listAllProject.size() > 0) {
                                                    for (ProjectDTO project : listAllProject) {
                                                    count++;
                                        %>
                                        
                                        <%
                                                                     listHirer = (List<HirerDTO>) session.getAttribute("LIST_HIRER");
                                                                    HirerDTO hirer = null;
                                                                    for (HirerDTO elem : listHirer) {
                                                                        if (elem.getHirerID() == project.getHirerID()) {
                                                                            hirer = elem;
                                                                        }
                                                                    }
                                                        %>  
                                        
                                    <div class="joblist-wrapper"><a href="#" class="click-link w-inline-block">
                                            <h3 class="heading-13"> <%= project.getProjectName()%> </h3>
                                            </a>
                                            <div>Price: <%= project.getPaymentAmount()%> - <%= project.getComplexity()%> - Post <%= localDate.getDayOfYear() - project.getCreatedDate().getDayOfYear() %> days Ago</div>
                                            <p class="paragraph"> <%= project.getDescription()%></p>
                                            <div class="div-block-7"><img loading="lazy"
                                                                          src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d915178de70c73cbd8e23_star.png"
                                                                          alt="" />
                                                <div> <%= hirer.getReviewGrade() %>/5 points</div>
                                            </div>
                                            
                                        <div class="seeker-skill-wrapper">
                                                <%
                                                    for (String skill : project.getSkillneed()) {
                                                %>
                                                <div class="seeker-skill"><%= skill%></div>
                                                <%
                                                    }
                                                %>
                                           
                                        </div>
                                            
                                        <div class="seeker-dividen"></div>
                                        <div class="lightbox-project-detail">
                                            <div data-w-id="9066dcf3-f84c-cbf2-e3fb-4d1d61584a24" class="close-div">
                                            </div>
                                            <div class="light-box-job-content">
                                                <div class="div-block-16"><img width="46" loading="lazy"
                                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6294321c437de4e9e1dfbcef_chevron-left.svg"
                                                        alt="" class="image-11" /></div>
                                                <div class="lb-jobdetail-wrapper">
                                                    <div class="lb-jobdetail-left">
                                                        <div class="lb-jobdetail-div">
                                                            <h1 class="heading-10"><%= project.getProjectName()%></h1>
                                                        </div>
                                                        <div class="lb-jobdetail-div">
                                                            <div class="lb-heading-text"><%= project.getMajor()%></div>
                                                            <div class="lb-text head">Post <%= localDate.getDayOfYear() - project.getCreatedDate().getDayOfYear() %> Days Ago</div>
                                                            <div class="lb-location-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629436cf2d0c464f33b2ff23_map-pin.svg"
                                                                    alt="" class="image-7" />
                                                                <div> <%= project.getLocation() %></div>
                                                            </div>
                                                        </div>
                                                        <div class="lb-jobdetail-div">
                                                            <div class="lb-text"><%= project.getDescription() %><br /></div>
                                                        </div>
                                                        <div class="lb-jobdetail-div horizontal">
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6294856546d2658dc08ad6f0_clock.png"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div class="text-block-16"><strong
                                                                            class="lb-condition-bold-text"><%= project.getHoursPerWeek()%> Hours</strong></div>
                                                                    <div class="lb-small-text">Hourly</div>
                                                                </div>
                                                            </div>
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62948564b5cf0e21235cdf86_calendar.png"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div><strong class="lb-condition-bold-text"><%= project.getExpectedDurationID()%></strong></div>
                                                                    <div class="text-block-14">Project Length</div>
                                                                </div>
                                                            </div>
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629485637925c58b3f06f159_mdi_head-cog.svg"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div class="lb-condition-bold-text"><strong
                                                                            class="bold-text"><%= project.getComplexity()%></strong>
                                                                    </div>
                                                                    <div class="text-block-12">Understanding of Major</div>
                                                                </div>
                                                            </div>
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629423f2cd8d721f22e4bafb_moeny.png"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div class="lb-condition-bold-text">
                                                                        <strong><%= project.getPaymentAmount()%>$</strong></div>
                                                                    <div class="text-block-12">Budget</div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                                                                                    <div class="lb-jobdetail-div">
                                                                <div class="lb-heading-text">Skill and Expertise</div>
                                                                <%
                                                                    for (String skill : project.getSkillneed()) {
                                                                %>
                                                                <div class="expected-skill"><%= skill%></div>
                                                                <%
                                                                    }
                                                                %>
                                                            </div>
                                                    </div>
                                                    <div class="lb-jobdetail-right">
                                                        <div class="lb-joblist-button-wrapper"><a href="MainController?action=FormSentProposal&projectID=<%= project.getProjectID()%>"
                                                                class="primary-button w-button">Submit a proposal</a><a
                                                                href="MainController?action=CreateFavoriteProject&projectID=<%= project.getProjectID()%>" class="primary-button sub w-button"> ♡ Save
                                                                job</a><a href="#"
                                                                class="lb-flag-wrapper w-inline-block"><img
                                                                    loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62948a9d2d0c46f777b5b766_flag.svg"
                                                                    alt="" class="image-9" />
                                                                <div class="text-block-17">Flag as inappropriate</div>
                                                            </a>
                                                            <div class="lb-text">Feel free to approach</div>
                                                        </div>
                                                        <div class="dividen"></div>
                                                        
                                                                   
                                                        
                                                        <div class="lb-about-client-wrapper">
                                                            <h3 class="heading-11">About client</h3>
                                                            <div class="lb-review-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d915178de70c73cbd8e23_star.png"
                                                                    alt="" class="image-10" />
                                                                <div class="lb-review-text"><%= hirer.getReviewGrade() %> Stars <br />of 999
                                                                    reviews</div>
                                                            </div>
                                                            <div class="lb-left-element-wrapper">
                                                                <h4 class="heading-12">Company: <%= hirer.getCompanyName() %></h4>
                                                                <div><%= hirer.getLocation() %></div>
                                                            </div>
                                                            <div class="lb-left-element-wrapper">
                                                                <h4 class="heading-12"><%= hirer.getJobPosted() %> Job Posted</h4>
                                                                <div>The total number of posted job</div>
                                                            </div>
                                                            <div class="lb-left-element-wrapper">
                                                                <h4 class="heading-12">$100k+ total spent</h4>
                                                                <div>90 hires, 12 active - cho nay chua lam</div>
                                                            </div>
                                                            <div>Member since <%= hirer.getRegistrationDate() %></div>
                                                        </div>
                                                         
                                                                    
                                                              
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                                                    
                                        <%
                                                    }
                                                }
                                            }
                                        %>
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                </div>
                                <div data-w-tab="Tab 3" class="w-tab-pane">
                                    <div class="text-block-5">Browse jobs that match your experience to a client&#x27;s
                                        hiring preferences.<br />Ordered by most relevant.</div>
                                    <div class="seeker-dividen"></div>
                                    
                                    <%            List<ProjectDTO> listFavoriteProject = (List<ProjectDTO>) request.getAttribute("LIST_FAVORITE_PROJECT");
                                            if (listFavoriteProject != null) {
                                                if (listFavoriteProject.size() > 0) {
                                                    for (ProjectDTO project : listFavoriteProject) {
                                        %>
                                        
                                        <%
                                                                    listHirer = (List<HirerDTO>) session.getAttribute("LIST_HIRER");
                                                                    HirerDTO hirer = null;
                                                                    for (HirerDTO elem : listHirer) {
                                                                        if (elem.getHirerID() == project.getHirerID()) {
                                                                            hirer = elem;
                                                                        }
                                                                    }
                                                        %>  
                                        
                                    <div class="joblist-wrapper"><a href="#" class="click-link w-inline-block">
                                            <h3 class="heading-13"> <%= project.getProjectName()%> </h3>
                                            </a>
                                            <div>Price: <%= project.getPaymentAmount()%> - <%= project.getComplexity()%> - Post <%= localDate.getDayOfYear() - project.getCreatedDate().getDayOfYear() %> days Ago</div>
                                            <p class="paragraph"> <%= project.getDescription()%></p>
                                            <div class="div-block-7"><img loading="lazy"
                                                                          src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d915178de70c73cbd8e23_star.png"
                                                                          alt="" />
                                                <div> <%= hirer.getReviewGrade() %>/5 points</div>
                                            </div>
                                            
                                        <div class="seeker-skill-wrapper">
                                                <%
                                                    for (String skill : project.getSkillneed()) {
                                                %>
                                                <div class="seeker-skill"><%= skill%></div>
                                                <%
                                                    }
                                                %>
                                           
                                        </div>
                                            
                                        <div class="seeker-dividen"></div>
                                        <div class="lightbox-project-detail">
                                            <div data-w-id="9066dcf3-f84c-cbf2-e3fb-4d1d61584a24" class="close-div">
                                            </div>
                                            <div class="light-box-job-content">
                                                <div class="div-block-16"><img width="46" loading="lazy"
                                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6294321c437de4e9e1dfbcef_chevron-left.svg"
                                                        alt="" class="image-11" /></div>
                                                <div class="lb-jobdetail-wrapper">
                                                    <div class="lb-jobdetail-left">
                                                        <div class="lb-jobdetail-div">
                                                            <h1 class="heading-10"><%= project.getProjectName()%></h1>
                                                        </div>
                                                        <div class="lb-jobdetail-div">
                                                            <div class="lb-heading-text"><%= project.getMajor()%></div>
                                                            <div class="lb-text head">Post <%= localDate.getDayOfYear() - project.getCreatedDate().getDayOfYear() %> Days Ago</div>
                                                            <div class="lb-location-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629436cf2d0c464f33b2ff23_map-pin.svg"
                                                                    alt="" class="image-7" />
                                                                <div> <%= project.getLocation() %></div>
                                                            </div>
                                                        </div>
                                                        <div class="lb-jobdetail-div">
                                                            <div class="lb-text"><%= project.getDescription() %><br /></div>
                                                        </div>
                                                        <div class="lb-jobdetail-div horizontal">
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6294856546d2658dc08ad6f0_clock.png"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div class="text-block-16"><strong
                                                                            class="lb-condition-bold-text"><%= project.getHoursPerWeek()%> Hours</strong></div>
                                                                    <div class="lb-small-text">Hourly</div>
                                                                </div>
                                                            </div>
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62948564b5cf0e21235cdf86_calendar.png"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div><strong class="lb-condition-bold-text"><%= project.getExpectedDurationID()%></strong></div>
                                                                    <div class="text-block-14">Project Length</div>
                                                                </div>
                                                            </div>
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629485637925c58b3f06f159_mdi_head-cog.svg"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div class="lb-condition-bold-text"><strong
                                                                            class="bold-text"><%= project.getComplexity()%></strong>
                                                                    </div>
                                                                    <div class="text-block-12">Understanding of Major</div>
                                                                </div>
                                                            </div>
                                                            <div class="specific-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629423f2cd8d721f22e4bafb_moeny.png"
                                                                    alt="" class="image-8" />
                                                                <div>
                                                                    <div class="lb-condition-bold-text">
                                                                        <strong><%= project.getPaymentAmount()%>$</strong></div>
                                                                    <div class="text-block-12">Budget</div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                                                                                    <div class="lb-jobdetail-div">
                                                                <div class="lb-heading-text">Skill and Expertise</div>
                                                                <%
                                                                    for (String skill : project.getSkillneed()) {
                                                                %>
                                                                <div class="expected-skill"><%= skill%></div>
                                                                <%
                                                                    }
                                                                %>
                                                            </div>
                                                    </div>
                                                    <div class="lb-jobdetail-right">
                                                        <div class="lb-joblist-button-wrapper"><a href="MainController?action=FormSentProposal&projectID=<%= project.getProjectID()%>"
                                                                class="primary-button w-button">Submit a proposal</a><a
                                                                href="MainController?action=CreateFavoriteProject&projectID=<%= project.getProjectID()%>" class="primary-button sub w-button"> ♡ Save
                                                                job</a><a href="#"
                                                                class="lb-flag-wrapper w-inline-block"><img
                                                                    loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62948a9d2d0c46f777b5b766_flag.svg"
                                                                    alt="" class="image-9" />
                                                                <div class="text-block-17">Flag as inappropriate</div>
                                                            </a>
                                                            <div class="lb-text">Feel free to approach</div>
                                                        </div>
                                                        <div class="dividen"></div>
                                                        
                                                                   
                                                        
                                                        <div class="lb-about-client-wrapper">
                                                            <h3 class="heading-11">About client</h3>
                                                            <div class="lb-review-wrapper"><img loading="lazy"
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d915178de70c73cbd8e23_star.png"
                                                                    alt="" class="image-10" />
                                                                <div class="lb-review-text"><%= hirer.getReviewGrade() %> Stars <br />of 999
                                                                    reviews</div>
                                                            </div>
                                                            <div class="lb-left-element-wrapper">
                                                                <h4 class="heading-12">Company: <%= hirer.getCompanyName() %></h4>
                                                                <div><%= hirer.getLocation() %></div>
                                                            </div>
                                                            <div class="lb-left-element-wrapper">
                                                                <h4 class="heading-12"><%= hirer.getJobPosted() %> Job Posted</h4>
                                                                <div>The total number of posted job</div>
                                                            </div>
                                                            <div class="lb-left-element-wrapper">
                                                                <h4 class="heading-12">$100k+ total spent</h4>
                                                                <div>90 hires, 12 active - cho nay chua lam</div>
                                                            </div>
                                                            <div>Member since <%= hirer.getRegistrationDate() %></div>
                                                        </div>
                                                         
                                                                    
                                                              
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                                                    
                                        <%
                                                    }
                                                }
                                            }
                                        %>
                                    
                                    
                                    
                                    
                                    
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="right-side">
                    <div class="right-wrapper">
                        <div class="heading-right-container"><img
                                src="<%= loginUser.getAvatar()%> "
                                loading="lazy" sizes="(max-width: 479px) 100vw, (max-width: 767px) 14vw, 100px"
                                srcset="<%= loginUser.getAvatar()%> 500w, <%= loginUser.getAvatar()%>  960w"
                                alt="" class="image-5" />
                            <h2 class="heading-3"><%= loginUser.getFullName()%></h2>
                            <div class="text-block-4"><strong><%= loginUser.getMajor()%></strong> |<br /> <%= loginUser.getOverview()%> </div>
                        </div>
                        <div class="ividen"></div>
                        <div class="div-block-22">
                            <div class="text-block-19">Number of available jobs</div>
                            <div id="progress-bar" class="progress-bar"></div>
                            <div class="text-block-20"><%= count %>/100</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=628aea177e2bdc5cebb3b655"
        type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
    <script src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/js/webflow.e3e276480.js"
        type="text/javascript"></script>
    <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
    
    
</body>

</html>