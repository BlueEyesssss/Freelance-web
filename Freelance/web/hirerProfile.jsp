<%@page import="sample.proposal.ProposalDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="sample.hirer.HirerDTO"%>
<!DOCTYPE html><!-- This site was created in Webflow. http://www.webflow.com -->
<!-- Last Published: Sat Jun 18 2022 08:45:03 GMT+0000 (Coordinated Universal Time) -->
<html data-wf-domain="upwork-7e964a.webflow.io" data-wf-page="6296b69f7f3f296ebff1f241"
      data-wf-site="628aea177e2bdc5cebb3b655" data-wf-status="1">

    <head>
        <meta charset="utf-8" />
        <title>Seeker Profile</title>
        <meta content="Seeker Profile" property="og:title" />
        <meta content="Seeker Profile" property="twitter:title" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Webflow" name="generator" />
        <link href="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/css/upwork-7e964a.webflow.b441a19dc.css"
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
        <link href="https://uploads-ssl.webflow.com/img/webclip.png" rel="apple-touch-icon" />
        <style>
            .w-webflow-badge {
                display: none !important;
            }
        </style>
    </head>
    <%
        HirerDTO hirer = (HirerDTO) session.getAttribute("USER_LOGIN");
    %>
    <body class="user-body">
        <div data-collapse="medium" data-animation="default" data-duration="400" data-easing="ease" data-easing2="ease"
             role="banner" class="navigation seeker w-nav">
            <div class="navigation-container">
                <div class="navigation-menu"><a href="MainController?action=ViewHirerDashboard" class="brand w-nav-brand"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628aeb849e24d09f04fa55e0_logo.png"
                            loading="lazy" alt="" class="logo-image biglogo" /></a>
                    <div class="nav-search-wrapper">
                        <div class="nav-icon-search"><img
                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6296b474e000b451cf79e812_search-white.svg"
                                loading="lazy" alt="" /></div>
                        <div class="nav-search-input">
                            <div class="w-form">
                                <form id="email-form-2" name="email-form-2" data-name="Email Form 2" method="get"><input
                                        type="text" class="search-input w-input" maxlength="256" name="name"
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
                        <div data-hover="true" data-delay="0" class="link nav-link w-dropdown">
                            <div class="dropdown-toggle-2 w-dropdown-toggle">
                                <div class="text-block-22">My Job</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="postAJob.jsp"
                                                                            class="dropdown-link-nav w-dropdown-link">Post a Job</a><a href="#"
                                                                            class="dropdown-link-nav w-dropdown-link">All contract</a><a href="#"
                                                                            class="dropdown-link-nav w-dropdown-link">Hire</a></nav>
                        </div>
                        <div data-hover="true" data-delay="0" class="link-4 nav-link w-dropdown">
                            <div class="dropdown-toggle-3 w-dropdown-toggle">
                                <div class="text-block-22">Find Talent</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="#"
                                                                            class="dropdown-moi-qua-troi-moi w-dropdown-link" style="color: white">Find Talent</a></nav>
                        </div>
                    </div><a href="#" class="w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d693684f77e4900d5de82_send.png"
                            loading="lazy" alt="" class="image-3" /></a><a href="#" class="w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d69352ef8ea1801f37308_bell.png"
                            loading="lazy" alt="" /></a>
                    <div class="navigation-button-wrapper">
                        <div data-hover="false" data-delay="0" class="w-dropdown">
                            <div class="dropdown-toggle w-dropdown-toggle"><img
                                    src=<%= hirer.getAvatar()%>
                                    loading="lazy" width="90"
                                    sizes="(max-width: 479px) 100vw, (max-width: 767px) 43.134765625px, 6vw"
                                    srcset="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n-p-500.jpeg 500w, https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n.jpeg 960w"
                                    alt="" class="avatar-img-nav" /></div>
                            <nav class="dropdown-list w-dropdown-list">
                                <a href="#" class="dropdown-link w-dropdown-link">My
                                    Profile</a>
                                <a href="MainController?action=ViewBalanceHirerSeeker"
                                   class="dropdown-link w-dropdown-link">My Balance</a>
                                <a href="MainController?action=Logout" class="dropdown-link w-dropdown-link">Log out</a></nav>
                        </div>
                    </div>
                </div>
                <div class="menu-button w-nav-button">
                    <div class="w-icon-nav-menu"></div>
                </div>
            </div>
        </div>

        <div class="section-2 wf-section">
            <div class="container-1200 w-container">
                <div class="main-information-wrapper">
                    <div class="seeker-header-div">
                        <div class="seeker-header-div-left"><img
                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n.jpeg"
                                loading="lazy" sizes="(max-width: 479px) 100vw, 110px"
                                srcset="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n-p-500.jpeg 500w, https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n.jpeg 960w"
                                alt="" class="image-12" />
                            <div>
                                <h1 class="heading-14"><%= hirer.getCompanyName()%></h1>
                                <div class="div-block-28"><img
                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62ad86a39e3a4d61d6e7512e_Account%20balance%20wallet.svg"
                                        loading="lazy" width="21" alt="" class="image-13" />
                                    <div class="text-block-21"><br /><%= hirer.getTotalSpent()%>$</div>
                                </div>
                            </div>
                        </div>
                        <div class="seeker-header-div-right"><a data-w-id="8ae2a92a-3f7b-8a07-bbf2-0fe10e32d3e2" href="#"
                                                                class="main-button w-button">Change password</a>
                            <div class="seeker-edit-lightbox password">
                                <div data-w-id="8ae2a92a-3f7b-8a07-bbf2-0fe10e32d3e5" class="close-lb-div"></div>
                                <div class="seeker-edit-lb-wrapper password">
                                    <div class="lb-heading">
                                        <h2 class="heading-15">Change password</h2><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                            loading="lazy" data-w-id="8ae2a92a-3f7b-8a07-bbf2-0fe10e32d3ea" alt=""
                                            class="image-14" />
                                    </div>
                                    <div class="lb-form-edit-wrapper">
                                        <div class="w-form">
                                            <form id="email-form" name="email-form" data-name="Email Form" method="get"
                                                  class="edit-lightbox-form">
                                                <div class="div-vertical">
                                                    <div class="div-vertical _w-80">
                                                        <div class="text-block-33">Current password</div><input
                                                            type="password" class="text-field-4 password w-input"
                                                            maxlength="256" name="currentPassword"
                                                            data-name="currentPassword" placeholder=""
                                                            id="currentPassword" required="" />
                                                        <font style="color: red">${requestScope.ERROR_CREATE.passwordNotCorrect}</font>
                                                    </div>
                                                    <div class="div-vertical _w-80">
                                                        <div class="text-block-33">New password</div><input type="password"
                                                                                                            class="text-field-4 password w-input" maxlength="256"
                                                                                                            name="newpassword" data-name="newpassword" placeholder=""
                                                                                                            id="newpassword" required="" />
                                                        <font style="color: red">${requestScope.ERROR_CREATE.password}</font>
                                                    </div>
                                                    <div class="div-vertical _w-80">
                                                        <div class="text-block-33">Confirm password</div><input
                                                            type="password" class="text-field-4 password w-input"
                                                            maxlength="256" name="confirmpassword"
                                                            data-name="confirmpassword" placeholder=""
                                                            id="confirmpassword" required="" />
                                                        <font style="color: red">${requestScope.ERROR_CREATE.confirm}</font>
                                                    </div>
                                                </div>
                                                <div class="lb-edit-button-wrapper"><a
                                                        data-w-id="8ae2a92a-3f7b-8a07-bbf2-0fe10e32d3fc" href="#"
                                                        class="main-button sub-button seeker-lb w-button">Cancel</a><input
                                                        type="submit" value="Save Password" name="action" data-wait="Please wait..."
                                                        class="main-button w-button" /></div>
                                                    ${requestScope.ERROR_UPDATE_INF_SEEKER}
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
                        </div>
                    </div>
                    <div>
                        <div class="hirer-basic-infor">
                            <div class="hirer-heading-wrapper no-border">
                                <h1 class="heading-tittle">Basic information<br /></h1>
                            </div>
                            <div class="div-horizon space-between paddding-2side">
                                <div class="div-vertical">
                                    <div class="my-bio"><strong><%= hirer.getFullName()%></strong></div>
                                    <div class="div-block-28 padding-top"><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62ad888535688426d2966a6f_mail.svg"
                                            loading="lazy" alt="" class="image-13" />
                                        <div class="text-block-21"><br /><%= hirer.getEmail()%></div>
                                    </div>
                                    <div class="div-block-28 padding-top"><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6296c1f76519c0d7c2b00673_map-pin.svg"
                                            loading="lazy" alt="" class="image-13" />
                                        <div class="text-block-21"><br /><%= hirer.getLocation()%></div>
                                    </div>
                                    <div class="div-block-28 padding-top"><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62ad878ada20c802d2fd635f_phone.svg"
                                            loading="lazy" alt="" class="image-13" />
                                        <div class="text-block-21"><br /><%= hirer.getPhone()%></div>
                                    </div>
                                </div><img
                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62972cb6f2d88ab16b24b133_clarity_edit-solid.svg"
                                    loading="lazy" data-w-id="8ae2a92a-3f7b-8a07-bbf2-0fe10e32d4dc" alt=""
                                    class="icon-edit hour-rate" />
                                <div class="seeker-edit-lightbox basic-hirer">
                                    <div class="seeker-edit-lb-wrapper basichirer">
                                        <div class="lb-heading">
                                            <h2 class="heading-15">Basic information</h2><img
                                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                                loading="lazy" data-w-id="8ae2a92a-3f7b-8a07-bbf2-0fe10e32d4e2" alt=""
                                                class="image-14" />
                                        </div>
                                        <div class="lb-form-edit-wrapper">
                                            <div class="w-form">
                                                <form id="email-form" name="email-form" data-name="Email Form" method="get"
                                                      class="edit-lightbox-form">
                                                    <div class="lb-edit-button-wrapper"><a
                                                            data-w-id="8ae2a92a-3f7b-8a07-bbf2-0fe10e32d4f6" href="#"
                                                            class="main-button sub-button seeker-lb w-button">Cancel</a><input
                                                            type="submit" value="Save" data-wait="Please wait..."
                                                            class="main-button w-button" /></div>
                                                    <div class="hirer-element-form">
                                                        <div class="hirer-element-form"><label
                                                                for="name-2"><strong>Name</strong></label><input type="text"
                                                                class="text-field w-input" maxlength="256" name="name"
                                                                data-name="name" placeholder="" id="name-2" required="" />
                                                        </div>
                                                        <div class="hirer-element-form"><label
                                                                for="email"><strong>Email</strong></label><input
                                                                type="email" class="text-field w-input" maxlength="256"
                                                                name="email" data-name="email" placeholder="" id="email"
                                                                required="" /></div>
                                                        <div class="hirer-element-form"><label
                                                                for="phone"><strong>Phone</strong></label><input type="tel"
                                                                class="text-field w-input" maxlength="256" name="phone"
                                                                data-name="phone" placeholder="" id="phone" required="" />
                                                        </div>
                                                        <div class="hirer-element-form last-child"><label
                                                                for="location"><strong>Location</strong></label><input
                                                                type="text" class="text-field w-input" maxlength="256"
                                                                name="location" data-name="location" placeholder=""
                                                                id="location" required="" /></div>
                                                    </div>
                                                </form>
                                                <div class="w-form-done">
                                                    <div>Thank you! Your submission has been received!</div>
                                                </div>
                                                <div class="w-form-fail">
                                                    <div>Oops! Something went wrong while submitting the form.</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div data-w-id="8ae2a92a-3f7b-8a07-bbf2-0fe10e32d4ff" class="close-lb-div"></div>
                                    </div>
                                    <div data-w-id="8ae2a92a-3f7b-8a07-bbf2-0fe10e32d500" class="close-lb-div"></div>
                                </div>
                            </div>
                        </div>
                        <div class="hirer-companydetail">
                            <div class="hirer-heading-wrapper">
                                <h1 class="heading-tittle">Company Detail<br /></h1>
                            </div>
                            <div class="div-horizon padding-2side space-between">
                                <div class="div-vertical">
                                    <div class="my-bio"><strong><%= hirer.getCompanyName()%></strong></div>
                                    <div class="text-block-151">KMS Technology has a global footprint with a suite of
                                        companies targeted to serve clients in their respective regions and industries.
                                    </div>
                                    <div class="div-block-28 padding-top"><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6296c1f76519c0d7c2b00673_map-pin.svg"
                                            loading="lazy" alt="" class="image-13" />
                                        <div class="text-block-21"><br /><%= hirer.getLocation()%></div>
                                    </div><a href="#" class="div-block-28 padding-top link w-inline-block"><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62ad8887b7f9517b32a0b7d7_website.svg"
                                            loading="lazy" alt="" class="image-13" />
                                        <div class="text-block-21"><br />https://kms-technology.com/</div>
                                    </a>
                                </div><img
                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62972cb6f2d88ab16b24b133_clarity_edit-solid.svg"
                                    loading="lazy" data-w-id="8ae2a92a-3f7b-8a07-bbf2-0fe10e32d538" alt=""
                                    class="icon-edit" />
                                <div class="seeker-edit-lightbox company-detail">
                                    <div class="seeker-edit-lb-wrapper basichirer">
                                        <div class="lb-heading">
                                            <h2 class="heading-15">Company Information</h2><img
                                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                                loading="lazy" data-w-id="ad827dd1-8e23-bbaf-19e0-44686df7dc8b" alt=""
                                                class="image-14" />
                                        </div>
                                        <div class="lb-form-edit-wrapper">
                                            <div class="w-form">
                                                <form id="email-form" name="email-form" data-name="Email Form" method="get"
                                                      class="edit-lightbox-form">
                                                    <div class="lb-edit-button-wrapper"><a
                                                            data-w-id="ad827dd1-8e23-bbaf-19e0-44686df7dc90" href="#"
                                                            class="main-button sub-button seeker-lb w-button">Cancel</a><input
                                                            type="submit" value="Save" data-wait="Please wait..."
                                                            class="main-button w-button" /></div>
                                                    <div class="hirer-element-form">
                                                        <div class="hirer-element-form"><label
                                                                for="companyName"><strong>Company
                                                                    Name</strong></label><input type="text"
                                                                                        class="text-field w-input" maxlength="256"
                                                                                        name="companyName" data-name="companyName" placeholder=""
                                                                                        id="companyName" required="" /></div>
                                                        <div class="hirer-element-form"><label
                                                                for="companyDescrip"><strong>Description</strong></label><input
                                                                type="email" class="text-field w-input" maxlength="256"
                                                                name="companyDescrip" data-name="companyDescrip"
                                                                placeholder="" id="companyDescrip" required="" /></div>
                                                        <div class="hirer-element-form"><label
                                                                for="companyLocation"><strong>Location</strong></label><input
                                                                type="tel" class="text-field w-input" maxlength="256"
                                                                name="companyLocation" data-name="companyLocation"
                                                                placeholder="" id="companyLocation" required="" /></div>
                                                        <div class="hirer-element-form last-child"><label
                                                                for="companyWebsite"><strong>Website</strong></label><input
                                                                type="text" class="text-field w-input" maxlength="256"
                                                                name="companyWebsite" data-name="companyWebsite"
                                                                placeholder="" id="companyWebsite" required="" /></div>
                                                    </div>
                                                </form>
                                                <div class="w-form-done">
                                                    <div>Thank you! Your submission has been received!</div>
                                                </div>
                                                <div class="w-form-fail">
                                                    <div>Oops! Something went wrong while submitting the form.</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div data-w-id="ad827dd1-8e23-bbaf-19e0-44686df7dcae" class="close-lb-div"></div>
                                    </div>
                                    <div data-w-id="ad827dd1-8e23-bbaf-19e0-44686df7dcaf" class="close-lb-div"></div>
                                </div>
                            </div>
                        </div>
                        <div class="div-block-140">
                            <div class="hirer-heading-wrapper">
                                <h1 class="heading-tittle">Work History<br /></h1>
                            </div>
                            <div class="div-vertical">
                                <%            List<ProposalDTO> listHistoryProject = (List<ProposalDTO>) request.getAttribute("LIST_HISTORY_PROJECT");
                                    if (listHistoryProject != null) {
                                        if (listHistoryProject.size() != 0) {
                                            for (ProposalDTO proposal : listHistoryProject) {
                                %>
                                <div class="job-history-wrapper padding-2side">
                                    <div class="job-history-element">
                                        <div class="history-left">
                                            <h4 class="heading-18"><%= proposal.getProjectName()%></h4>
                                            <div>June 2021 - July 2021</div>
                                            <div class="no-feedback">If no feedback: No feedback</div>
                                            <div class="review-feedback">If has feedback: Excellent!</div>
                                            <div class="review-stars-wrapper"><img loading="lazy"
                                                                                   src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d915178de70c73cbd8e23_star.png"
                                                                                   alt="" />
                                                <div> 4,5/5 points</div>
                                            </div>
                                        </div>
                                        <div class="history-right">
                                            <h4 class="heading-17">20 hours</h4>
                                            <div class="text-block-30">$10$ / h</div>
                                            <div class="text-block-30">$200 spended</div>
                                        </div>
                                    </div>
                                </div>
                                <%
                                        }
                                    }
                                } else {
                                %>
                                <div class="text-block-seeker">No work yet. Once you start getting hired on Upwork, your
                                    work with clients will show up here.</div>

                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="testimonial-session">
                    <div class="seeker-header-div testimonial">
                        <h1 class="heading-tittle">Testimonials</h1>
                        <div>Review from past hirer<br /></div>
                    </div>

                    <%            List<ProposalDTO> feedbacks = (List<ProposalDTO>) request.getAttribute("FEED_BACK_OF_SEEKER");
                        if (feedbacks != null) {
                            if (feedbacks.size() != 0) {
                                for (ProposalDTO feedback : feedbacks) {
                    %>

                    <div class="testimonial-wrapper">
                        <div class="testimonial-element">
                            <p class="paragraph-2">&quot;Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                                Suspendisse varius enim in eros elementum tristique. Duis cursus, mi quis viverra ornare,
                                eros dolor interdum nulla, ut commodo diam libero vitae erat. Aenean faucibus nibh et justo
                                cursus id rutrum lorem imperdiet. Nunc ut sem vitae risus tristique posuere&quot;</p><img
                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629b3411c703f3ae535bae02_quote%20Icon.svg"
                                loading="lazy" width="34" alt="" class="image-16" />
                        </div>
                        <div class="div-horizon"><img
                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n.jpeg"
                                loading="lazy" sizes="50px"
                                srcset="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n-p-500.jpeg 500w, https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n.jpeg 960w"
                                alt="" class="image-15" />
                            <div class="div-vertical">
                                <h4 class="heading-19">Ecommerce Director - Lazada</h4>
                                <div class="text-block-31">Tittle Project: Data Scientist predict man</div>
                                <div class="text-block-32">April 2021</div>
                            </div>
                        </div>
                    </div>
                    <%
                            }
                        }
                    } else {
                    %>
                    
                    <div class="testimonial-element">
                            <p class="paragraph-2">&quot;Not Feedback yet!!&quot;</p>
                        </div>
                    <%
                        }
                    %>


                </div>
            </div>
        </div>
        <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=628aea177e2bdc5cebb3b655"
                type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
        <script src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/js/webflow.66f57ea5a.js"
        type="text/javascript"></script>
        <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
    </body>

</html>