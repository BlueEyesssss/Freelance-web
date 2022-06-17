<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="sample.project.ProjectDTO"%>
<!DOCTYPE html>
<html data-wf-domain="upwork-7e964a.webflow.io" data-wf-page="6296b682f8b462fb53aec689"
      data-wf-site="628aea177e2bdc5cebb3b655" data-wf-status="1">

    <head>
        <meta charset="utf-8" />
        <title>Proposal</title>
        <meta content="Proposal" property="og:title" />
        <meta content="Proposal" property="twitter:title" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Webflow" name="generator" />
        <link href="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/css/upwork-7e964a.webflow.69b293d70.css" rel="stylesheet" type="text/css">

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

    <body class="user-body">
        <div data-collapse="medium" data-animation="default" data-duration="400" data-easing="ease" data-easing2="ease"
             role="banner" class="navigation seeker w-nav">
            <div class="navigation-container">
                <div class="navigation-menu"><a href="MainController?action=ViewSeekerDashboard" class="brand w-nav-brand"><img
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
                                        data-name="Name" placeholder="Find job here" id="name" /><input type="submit" name="action" value="Search Job By Name"
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
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewSeekerDashboard"
                                                                            class="dropdown-link-nav w-dropdown-link">Find Work</a><a href="#"
                                                                            class="dropdown-link-nav w-dropdown-link">Save Jobs</a><a href="MainController?action=ViewProposal"
                                                                            class="dropdown-link-nav w-dropdown-link">Proposals</a></nav>
                        </div>
                        <div data-hover="true" data-delay="0" class="link nav-link w-dropdown">
                            <div class="dropdown-toggle-3 w-dropdown-toggle">
                                <div class="text-block-22">My Job</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewMyJob"
                                                                            class="dropdown-link-nav w-dropdown-link">My Job</a><a href="MainController?action=ViewContract"
                                                                            class="dropdown-link-nav w-dropdown-link">All Constract</a></nav>
                        </div>
                    </div><a href="#" class="w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d693684f77e4900d5de82_send.png"
                            loading="lazy" alt="" class="image-3" /></a><a href="#" class="w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d69352ef8ea1801f37308_bell.png"
                            loading="lazy" alt="" /></a>
                    <div class="navigation-button-wrapper">
                        <div data-hover="false" data-delay="0" class="w-dropdown">
                            <div class="dropdown-toggle w-dropdown-toggle"><img
                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n.jpeg"
                                    loading="lazy" width="90"
                                    sizes="(max-width: 479px) 100vw, (max-width: 767px) 44.458335876464844px, 6vw"
                                    srcset="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n-p-500.jpeg 500w, https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n.jpeg 960w"
                                    alt="" class="avatar-img-nav" /></div>
                            <nav class="dropdown-list w-dropdown-list"><a href="MainController?action=ViewSeekerProfile" class="dropdown-link w-dropdown-link">My
                                    Profile</a><a href="MainController?action=Logout" class="dropdown-link w-dropdown-link">Log out</a></nav>
                        </div>
                    </div>
                </div>
                <div class="menu-button w-nav-button">
                    <div class="w-icon-nav-menu"></div>
                </div>
            </div>
        </div>

        <%
            LocalDate localDate = LocalDate.now();
            List<String> listSkill = (List<String>)request.getAttribute("SKILL_PROJECT_NEED");
            ProjectDTO projectCurrent = (ProjectDTO) request.getAttribute("PROJECT_CURRENT");
            if (projectCurrent != null) {

        %>

        <div class="section-3 wf-section">
            <div class="container-1200 w-container">
                <div class="w-form">
                    <form action="MainController" id="email-form-3" name="email-form-3" data-name="Email Form 3" method="get">
                        <h2 class="heading-20">Submit a proposal<br /></h2>
                        <div class="proposal-heading-wrapper padding-top-50">
                            <div class="upwork-heading-div">
                                <h1 class="heading-10">Job Details</h1>
                            </div>
                            <div class="lb-jobdetail-div horizontal proposal">
                                <div class="div-70">
                                    <h3 class="heading-21">Expert Webflow developer to convert designs</h3>
                                    <div class="lb-text head">Posted <%= localDate.getDayOfYear() - projectCurrent.getCreatedDate().getDayOfYear() %> days Ago</div>
                                    <div class="lb-location-wrapper"><img loading="lazy"
                                                                          src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629436cf2d0c464f33b2ff23_map-pin.svg"
                                                                          alt="" class="image-9" />
                                        <div><%= projectCurrent.getLocation()%></div>
                                    </div>
                                    <div class="lb-text proposal">Discription:<%= projectCurrent.getDescription()%><br /></div>
                                    <div class="proposal-divenden"></div>
                                    <div class="div-block-33">
                                        <div class="lb-heading-text">Skill and Expertise</div>
                                        <%
                            for (String elem : listSkill) {
                                    %>
                                    
                                    <div class="expected-skill"><%= elem %></div>
                        <%
                                }
                        %>
                                        
                                          
                                    </div>
                                </div>
                                <div class="div-30 border-left padding-30">
                                    <div class="specific-wrapper proposal"><img loading="lazy"
                                                                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6294856546d2658dc08ad6f0_clock.png"
                                                                                alt="" class="image-8" />
                                        <div>
                                            <div class="text-block-16"><strong class="lb-condition-bold-text"><%= projectCurrent.getHoursPerWeek()%>
                                                    hrs/week</strong></div>
                                            <div class="lb-small-text">Hourly</div>
                                        </div>
                                    </div>
                                    <div class="specific-wrapper proposal"><img loading="lazy"
                                                                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62948564b5cf0e21235cdf86_calendar.png"
                                                                                alt="" class="image-8" />
                                        <div>
                                            <div><strong class="lb-condition-bold-text"><%= projectCurrent.getExpectedDurationID()%></strong></div>
                                            <div class="text-block-16">Project Length</div>
                                        </div>
                                    </div>
                                    <div class="specific-wrapper proposal"><img loading="lazy"
                                                                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629485637925c58b3f06f159_mdi_head-cog.svg"
                                                                                alt="" class="image-8" />
                                        <div>
                                            <div class="lb-condition-bold-text"><strong
                                                    class="bold-text"><%= projectCurrent.getComplexity()%></strong></div>
                                            <div class="text-block-16">I am looking for a mix of experience and value</div>
                                        </div>
                                    </div>
                                    <div class="specific-wrapper proposal"><img loading="lazy"
                                                                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629423f2cd8d721f22e4bafb_moeny.png"
                                                                                alt="" class="image-8" />
                                        <div>
                                            <div class="lb-condition-bold-text"><strong><%= projectCurrent.getPaymentAmount()%>$</strong></div>
                                            <div class="text-block-16">Budget</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="upwork-element-wrapper">
                            <div class="upwork-heading-div">
                                <h1 class="heading-10">Terms<br /></h1>
                            </div>
                            <div class="upwork-element-content-wrapper horizontal spacebetween">
                                <div class="div-70">
<!--                                    <h4 class="heading-22">What is the rate you&#x27;d like to bid for this job?<br /></h4>
                                    <div class="div-horizon space-between">
                                        <div class="text-block-35">Your profile rate: <strong>$12.00/hr</strong></div>
                                        <div class="text-block-35">Client?s budget: <strong>$25.00 - $45.00/hr</strong>
                                        </div>
                                    </div>-->
                                    <div class="div-horizon proposal-terms space-between padding-top-50">
                                        <div>
                                            <div><strong class="bold-text-3">Bid On</strong></div>
                                            <div>Total amount the client will see on your proposal</div>
                                        </div>
                                        <div>
                                            <div class="div-horizon _w-300px">
                                                <div class="hour-rate-input-wrapper"><img
                                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629423f2cd8d721f22e4bafb_moeny.png"
                                                        loading="lazy" alt="" /><input type="number"
                                                        class="text-field-5 w-input" maxlength="256" name="paymentAmount"
                                                        data-name="hourRate" placeholder="" id="hourRate-3" required="" />
                                                </div>
                                                <div>/Job</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="div-horizon proposal-terms space-between padding-top-50">
                                        <div>
                                            <div><strong class="bold-text-3">Duration</strong></div>
                                            <div>The time you expect to finish the job</div>
                                        </div>
                                        <div>
                                            <div class="div-horizon _w-300px"><select id="duration-2" name="durationID"
                                                                                      data-name="duration" class="select-field-5 w-select">
                                                    <option value="">Select one...</option>
                                                    <option value="1">Less than 1 month </option>
                                                    <option value="2">1-3 months</option>
                                                    <option value="3">3-6 months</option>
                                                    <option value="4">6 or more months</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="div-30"><img
                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629e18a45304da3e68d5fb94_Charco%20Mobile%20Life.svg"
                                        loading="lazy" width="327" alt="" class="image-17" /></div>
                            </div>
                        </div>
                        <div class="upwork-element-wrapper">
                            <div class="upwork-heading-div">
                                <h1 class="heading-23"><br /></h1>
                            </div>
                            <div class="upwork-element-content-wrapper">
                                <div class="lb-heading-text">Cover Letter</div><textarea placeholder="" maxlength="5000"
                                                                                         id="coverLetter" name="coverLetter" data-name="field" required=""
                                                                                         class="textarea-2 w-input"></textarea>
                                <div class="lb-heading-text">Attachments Links</div><input type="text"
                                                                                           class="text-field-6 w-input" maxlength="256" name="attachment" data-name="attachment"
                                                                                           placeholder="" id="attachment" />
                                <div class="text-block-36">Include work samples or other documents to support your
                                    application. Do not attach your résumé ? your profile is automatically forwarded to the
                                    client with your proposal.</div>
                            </div>
                        </div><input type="submit" value="SubmitAProposal" name="action" data-wait="Please wait..."
                                     class="main-button proposal w-button" />

                        <input type="hidden" name="projectID" value="<%=projectCurrent.getProjectID()%>"/><a href="#"
                                                                                                             class="button-2 w-button"><strong>Cancel</strong></a>
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
        <%            }
        %>
        <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=628aea177e2bdc5cebb3b655"
                type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
        <script src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/js/webflow.3e0145b11.js"
        type="text/javascript"></script>
        <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
    </body>

</html>