<%-- 
    Document   : contractsPage
    Created on : Jun 8, 2022, 7:20:02 PM
    Author     : Phat
--%>

<%@page import="sample.proposal.ProposalDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.seeker.SeekerDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-wf-domain="proposal-dd5572.webflow.io" data-wf-page="62963198e315b0778b4afa7b"
    data-wf-site="62963198e315b0b2ad4afa7a">

<head>
    <meta charset="utf-8" />
    <title>Contract Page</title>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="Webflow" name="generator" />
    <link href="https://uploads-ssl.webflow.com/62963198e315b0b2ad4afa7a/css/proposal-dd5572.webflow.3654e43a5.css"
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
 <%
        SeekerDTO loginUser = (SeekerDTO) session.getAttribute("USER_LOGIN");
        List<ProposalDTO> listDoneProposal = (List<ProposalDTO>) request.getAttribute("LIST_DONE_PROPOSAL");
        List<ProposalDTO> listWaitingProposal = (List<ProposalDTO>) request.getAttribute("LIST_WAITING_PROPOSAL");
    %>

<body class="body">
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
                        <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewSeekerDashboard"
                                                                            class="dropdown-link-nav w-dropdown-link">Find Work</a><a href="MainController?action=ViewProposal"
                                                                            class="dropdown-link-nav w-dropdown-link">Proposals</a></nav>
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
                                src=<%= loginUser.getAvatar() %>
                                loading="lazy" width="90" alt="" class="avatar-img-nav" /></div>
                        <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewSeekerProfile" class="dropdown-link w-dropdown-link">My
                                    Profile</a><a href="MainController?action=Logout" class="dropdown-link w-dropdown-link">Log out</a></nav>
                    </div>
                </div>
            </div>
            <div class="menu-button w-nav-button">
                <div class="w-icon-nav-menu"></div>
            </div>
        </div>
    </div>
    <div class="container-2 w-container">
        <div class="my-proposal">My Contracts</div>
    </div>
    <div class="container-3 w-container">
        <div class="invitations-wrapper">
            <div class="invitations">Done Contract (<%= listDoneProposal.size() %>)</div>
           
            <%      
                    
                    if (listDoneProposal != null) {
                        if (listDoneProposal.size() > 0) {
                            for (ProposalDTO proposal : listDoneProposal) {
                            
                %>
            
            <div class="submit-1">
                <div class="time-submit">Initiated <%= proposal.getCreatedDate() %></div>
                <div class="project-submit"><a href="MainController?action=ViewDoneContract&proposalID=<%= proposal.getProposalID()%>" class="job-submit"><%= proposal.getProjectName()  %></a></div>
                <div class="general-profile">General Profile</div>
            </div>
                <%
                            }
                        }
                    }
                %>
            
            
        </div>

        <div class="active-wrapper">
            <div class="invitations">Waiting Contracts (<%= listWaitingProposal.size() %>)</div>
            
            <%
                    if (listWaitingProposal != null) {
                        if (listWaitingProposal.size() > 0) {
                            for (ProposalDTO proposal : listWaitingProposal) {
                %>
            <div class="submit-1">
                <div class="time-submit">Initiated <%= proposal.getCreatedDate() %></div>
                <div class="project-submit"><a href="#" class="job-submit"><%= proposal.getProjectName()  %></a></div>
                <div class="general-profile">General Profile</div>
            </div>
            <%
                            }
                        }
                    }
                %>
            
        </div>
                
                <div style="min-height: 100px">
                    
                </div>
        

        
        
        
    </div><img
        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62972cb6f2d88ab16b24b133_clarity_edit-solid.svg"
        loading="lazy" data-w-id="6b08791a-9b55-c668-9d86-39c3a9463ea9" alt="" class="icon-edit special" />
    <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62963198e315b0b2ad4afa7a"
        type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
    <script src="https://uploads-ssl.webflow.com/62963198e315b0b2ad4afa7a/js/webflow.ab4a14ee7.js"
        type="text/javascript"></script>
    <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>

</html>