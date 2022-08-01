<%@page import="sample.hirer.HirerDTO"%>
<%@page import="sample.project.ProjectDTO"%>
<%@page import="sample.project.ProjectDAO"%>
<%@page import="sample.proposal.ProposalDTO"%>
<%@page import="sample.proposal.ProposalDAO"%>
<%@page import="sample.skill.SkillDAO"%>
<%@page import="sample.skill.SkillDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.seeker.SeekerDTO"%>
<%@page import="sample.seeker.SeekerDAO"%>
<%@page import="sample.user.UserDTO"%>
<%@page import="sample.user.UserDAO"%>
<!DOCTYPE html><!-- This site was created in Webflow. https://www.webflow.com -->
<!-- Last Published: Sat Jul 09 2022 16:48:10 GMT+0000 (Coordinated Universal Time) -->
<html data-wf-domain="upwork-7e964a.webflow.io" data-wf-page="6296b682f8b462fb53aec689"
      data-wf-site="628aea177e2bdc5cebb3b655" data-wf-status="1">

    <head>
        <meta charset="utf-8" />
        <title>Proposal</title>
        <meta content="Proposal" property="og:title" />
        <meta content="Proposal" property="twitter:title" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Webflow" name="generator" />
        <link href="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/css/upwork-7e964a.webflow.b103a0353.css"
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" integrity="sha512-8bHTC73gkZ7rZ7vpqUQThUDhqcNFyYi2xgDgPDHc+GXVGHXq+xPjynxIopALmOPqzo9JZj0k6OqqewdGO3EsrQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <style>
            .w-webflow-badge {
                display: none !important;
            }
            a:hover{
                text-decoration: inherit;
                color: inherit;

            }
        </style>
    </head>

    <body class="user-body">

        <div data-collapse="medium" data-animation="default" data-duration="400" data-easing="ease" data-easing2="ease"
             role="banner" class="navigation seeker hirer w-nav">
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
                                <form action="MainController" id="email-form-2" name="email-form-2" data-name="Email Form 2" method="get"><input
                                        type="text" class="search-input w-input" maxlength="256" name="Name"
                                        data-name="Name" placeholder="" id="name" /><input type="submit" name="action" value="Search Talent By Name"
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
                                                                            class="dropdown-link-nav w-dropdown-link">Post a job</a><a href="MainController?action=ViewContractOfHirer"
                                                                            class="dropdown-link-nav w-dropdown-link">All Contracts</a></nav>
                        </div>
                        <div data-hover="true" data-delay="0" class="link nav-link w-dropdown">
                            <div class="dropdown-toggle-3 w-dropdown-toggle">
                                <div class="text-block-22">Find Talent</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="GetAllSeeker"
                                                                            class="dropdown-link-nav w-dropdown-link">Find Talent</a></nav>
                        </div>
                    </div><a href="#" class="w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d693684f77e4900d5de82_send.png"
                            loading="lazy" alt="" class="image-3" /></a><a href="#" class="w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d69352ef8ea1801f37308_bell.png"
                            loading="lazy" alt="" /></a>
                    <div class="navigation-button-wrapper">
                        <%
                            HirerDTO hirer = (HirerDTO)session.getAttribute("USER_LOGIN");
                        %>
                        <div data-hover="false" data-delay="0" class="w-dropdown">
                            <div class="dropdown-toggle w-dropdown-toggle"><img
                                    src="uploads/<%= hirer.getAvatar() %>"
                                    loading="lazy" width="90"
                                    sizes="(max-width: 479px) 100vw, (max-width: 767px) 43.6875px, 6vw" alt=""
                                    class="avatar-img-nav" /></div>
                            <nav class="dropdown-list w-dropdown-list"><a href="MainController?action=ViewHirerProfile" class="dropdown-link w-dropdown-link">My
                                    Profile</a><a href="MainController?action=ViewBalanceHirerSeeker" class="dropdown-link w-dropdown-link">My Balance</a><a href="MainController?action=Logout"
                                                                                                                                                         class="dropdown-link w-dropdown-link">Log out</a></nav>
                        </div>
                    </div>
                </div>
                <div class="menu-button w-nav-button">
                    <div class="w-icon-nav-menu"></div>
                </div>
            </div>
        </div>

        <div class="searchtalent wf-section">
            <div class="container-1200 w-container">
                <div class="wrapper-search-job">
                    <div class="filter-left">
                        <div class="w-form">
                            
                            <form action="MainController" id="email-form-4" name="email-form-4" data-name="Email Form 4" method="get"><input
                                    type="submit" name="action" value="Search Talent" data-wait="Please wait..." class="main-button w-button" />
                                <div class="text-block-159"><strong>Name</strong></div><input type="text"
                                                                                              class="text-field-18 w-input" maxlength="256" name="Name" data-name="Name"
                                                                                              placeholder="" id="Name-3" required=""/>
                                <div>

                                    <div class="filter-accordion-wrapper">
                                        <div class="filter-accordion-heading">
                                            <div class="text-block-5-copy"><strong>Skill</strong></div><img
                                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62943201437de47785dfbc00_chevron-left.png"
                                                loading="lazy" alt="" class="image-18" />
                                        </div>

                                        <%
                                            List<SkillDTO> listSkillAll = (List<SkillDTO>) session.getAttribute("LIST_SKILL_ALL");
                                            for (SkillDTO elem : listSkillAll) {

                                        %>

                                        <div class="filter-accordion-content">
                                            
                                            <!-- <label class="w-checkbox text-block-5">
                                                
                                                <input type="radio" name="skillName-2" id="skillName-2"
                                                             data-name="Skill Name 2"
                                                             style="opacity:0;position:absolute;z-index:-1" />
                                                             <%=elem.getSkillName()%>
                                            </label></div> -->

                                            <label class="radio-field small w-radio" >
                                                <input type="radio" name="skillID" id="Entry-Level" 
                                                value=<%= elem.getSkillID()%> data-name="complexity" 
                                                class="w-form-formradioinput w-radio-input" required="">
                                                <span for="Entry-Level" class="radio-label-2 small w-form-label"><%=elem.getSkillName()%></span></label>
                                                 </div>
                                        <%                                        }

                                        %>

                                    </div>
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
                    <div class="fiter-right">
                        <div class="seeker-main no-pdtop">
                            <div data-current="Tab 1" data-easing="ease" data-duration-in="300" data-duration-out="100"
                                 class="tabs w-tabs">
                                <div class="tabs-menu w-tab-menu"><a data-w-tab="Tab 1"
                                                                     class="tab-link-tab-1 w-inline-block w-tab-link w--current">
                                        <div class="tab-text">Search</div>
                                    </a></div>
                                <div class="w-tab-content">
                                    <div data-w-tab="Tab 1" class="w-tab-pane w--tab-active">
                                        <div class="text-block-5">Browse jobs that match your experience to a client&#x27;s
                                            hiring preferences.<br />Ordered by most relevant.</div>
                                        <div class="seeker-dividen"></div>
                                        <%  UserDAO userDao = new UserDAO();
                                            UserDTO userIsSeeker = null;
                                            int star = -1;
                                            SeekerDAO seekerDao = new SeekerDAO();
                                        
                                            List<SeekerDTO> listSeeker =(List<SeekerDTO>)request.getAttribute("LIST_SEEKER");
                                            if (listSeeker != null) {
                                                if (!listSeeker.isEmpty()) {
                                                    for (SeekerDTO seeker : listSeeker) {
                                                        userIsSeeker = userDao.getUserByID(seeker.getSeekerID());
                                                        star = seekerDao.getReviewGrade(seeker.getSeekerID());

                                        %>
                                        <div class="talent-wrappper"><a data-w-id="21656960-52d5-5f8e-04ae-05ab3a417bbe"
                                                                        href="#" class="click-link-talent w-inline-block"><img
                                                    src="uploads/<%= userIsSeeker.getAvatar()%>"
                                                    loading="lazy"
                                                    srcset="uploads/<%= userIsSeeker.getAvatar()%>"
                                                    sizes="(max-width: 479px) 100vw, 99.99609375px" alt=""
                                                    class="image-23" />
                                                <div class="div-block-142">
                                                    <h3 class="heading-talent"><%=userIsSeeker.getFullName()%></h3>
                                                    <div class="text-block-153"><strong class="bold-text-81"><%= seeker.getMajor()%></strong></div>
                                                    <div class="text-block-152"><%=userIsSeeker.getLocation()%></div>
                                                </div>
                                            </a>
                                            <!-- <div class="heart-wrapper talent-heart"><img
                                                    data-w-id="21656960-52d5-5f8e-04ae-05ab3a417bc9" loading="lazy"
                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62962a3a870f5430ff35871f_heart.svg"
                                                    alt="" class="icon-heart" /><img style="display:none"
                                                    data-w-id="21656960-52d5-5f8e-04ae-05ab3a417bca"
                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62962a3896c88f623a54351f_heart-fill.svg"
                                                    loading="lazy" alt="" class="icon-heart-fill" /></div> -->
                                            <div class="div-horizon _3-column margin-20">
                                                <div class="text-block-154"><strong>$<%=seeker.getMoneyPerHour()%></strong>/hr</div>
                                                <!-- <div class="text-block-155"><strong>$10k+ </strong>earned</div>
                                                <div class="text-block-156"><strong>96% </strong>Job Success</div> -->
                                            </div>
                                            <p class="paragraph-3"><%= seeker.getOverview()%></p>
                                            <div class="review-stars-wrapper"><img loading="lazy"
                                                                                   src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d915178de70c73cbd8e23_star.png"
                                                                                   alt="" />
                                                <div> <%=star%>/5 points</div>
                                            </div>
                                            <%
                                                SkillDAO skillDao = new SkillDAO();
                                                List<SkillDTO> listSkillOfSeeker = skillDao.getListSkillIDOfSeeker(seeker.getSeekerID());
                                            %>

                                            <div class="seeker-skill-wrapper">
                                                <%for (SkillDTO skill : listSkillOfSeeker) {
                                                %>
                                                <div class="seeker-skill"><%= skill.getSkillName()%></div>
                                                <%
                                                    }
                                                %>


                                            </div>

                                            <div class="seeker-dividen"></div>
                                                                                       
                                            <div style="opacity:0" class="lightbox-project-detail">
                                                <div data-w-id="21656960-52d5-5f8e-04ae-05ab3a417bed" class="close-div">
                                                </div>
                                                <div class="light-box-job-content">
                                                    <div class="div-block-16"><img width="46" loading="lazy"
                                                                                   src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6294321c437de4e9e1dfbcef_chevron-left.svg"
                                                                                   alt="" class="image-11" /></div>
                                                    <div class="lb-jobdetail-wrapper">
                                                        <div class="lb-jobdetail-left d-none">
                                                            <div class="lb-jobdetail-div">
                                                                <h1 class="heading-10">Webflow Personal Website</h1>
                                                            </div>
                                                            <div class="lb-jobdetail-div">
                                                                <div class="lb-heading-text">Web design</div>
                                                                <div class="lb-text head">Posted 1 day ago</div>
                                                                <div class="lb-location-wrapper"><img loading="lazy"
                                                                                                      src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629436cf2d0c464f33b2ff23_map-pin.svg"
                                                                                                      alt="" class="image-7" />
                                                                    <div> Saigon</div>
                                                                </div>
                                                            </div>
                                                            <div class="lb-jobdetail-div">
                                                                <div class="lb-text">Discription: Hi! I have a personal
                                                                    Webflow site that is almost done (based on an existing
                                                                    Webflow template). It needs some small tweaks (eg.
                                                                    centering nav bar, formatting text, linking to external
                                                                    links, and images, removing some items from the
                                                                    template, updating CMS collection). No creative input
                                                                    needed, I will send very specific instructions! Thank
                                                                    you<br /></div>
                                                            </div>
                                                            <div class="lb-jobdetail-div horizontal">
                                                                <div class="specific-wrapper"><img loading="lazy"
                                                                                                   src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6294856546d2658dc08ad6f0_clock.png"
                                                                                                   alt="" class="image-8" />
                                                                    <div>
                                                                        <div class="text-block-16"><strong
                                                                                class="lb-condition-bold-text">Less than 30
                                                                                hrs/week</strong></div>
                                                                        <div class="lb-small-text">Hourly</div>
                                                                    </div>
                                                                </div>
                                                                <div class="specific-wrapper"><img loading="lazy"
                                                                                                   src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62948564b5cf0e21235cdf86_calendar.png"
                                                                                                   alt="" class="image-8" />
                                                                    <div>
                                                                        <div><strong class="lb-condition-bold-text">Less
                                                                                than a month</strong></div>
                                                                        <div class="text-block-14">Project Length</div>
                                                                    </div>
                                                                </div>
                                                                <div class="specific-wrapper"><img loading="lazy"
                                                                                                   src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629485637925c58b3f06f159_mdi_head-cog.svg"
                                                                                                   alt="" class="image-8" />
                                                                    <div>
                                                                        <div class="lb-condition-bold-text"><strong
                                                                                class="bold-text">Intermediate</strong>
                                                                        </div>
                                                                        <div class="text-block-12">I am looking for a mix of
                                                                            experience and value</div>
                                                                    </div>
                                                                </div>
                                                                <div class="specific-wrapper"><img loading="lazy"
                                                                                                   src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629423f2cd8d721f22e4bafb_moeny.png"
                                                                                                   alt="" class="image-8" />
                                                                    <div>
                                                                        <div class="lb-condition-bold-text">
                                                                            <strong>100$</strong></div>
                                                                        <div class="text-block-12">Budget</div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="lb-jobdetail-div">
                                                                <div class="lb-heading-text">Skill and Expertise</div>
                                                                <div class="expected-skill">My skill</div>
                                                                <div class="expected-skill">My skill</div>
                                                                <div class="expected-skill">My skill</div>
                                                                <div class="expected-skill">My skill</div>
                                                            </div>
                                                        </div>
                                                        <div class="lb-jobdetail-right d-none">
                                                            <div class="lb-joblist-button-wrapper"><a href="#"
                                                                                                      class="primary-button w-button">Submit a proposal</a><a
                                                                                                      href="#" class="primary-button sub w-button"> ? Save
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
                                                                    <div class="lb-review-text"><%=star%>/5 Reviews<br />of 999
                                                                        reviews</div>
                                                                </div>
                                                                <div class="lb-left-element-wrapper">
                                                                    <h4 class="heading-12">ABC Company</h4>
                                                                    <div>Saigon</div>
                                                                </div>
                                                                <div class="lb-left-element-wrapper">
                                                                    <h4 class="heading-12">15 jobs posted</h4>
                                                                    <div>79% hire rate, 1 open job</div>
                                                                </div>
                                                                <div class="lb-left-element-wrapper">
                                                                    <h4 class="heading-12">$100k+ total spent</h4>
                                                                    <div>90 hires, 12 active</div>
                                                                </div>
                                                                <div>Member since May 30, 2022</div>
                                                            </div>
                                                        </div>




                                                        <div class="main-information-wrapper">
                                                            <div class="seeker-header-div">
                                                                <div class="seeker-header-div-left"><img
                                                                        loading="lazy"
                                                                        srcset="uploads/<%= userIsSeeker.getAvatar()%>"
                                                                        sizes="100vw" alt="" class="image-12" />
                                                                    <div>
                                                                        <h1 class="heading-14"><%=userIsSeeker.getFullName()%></h1>
                                                                        <div class="div-block-28"><img
                                                                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6296c1f76519c0d7c2b00673_map-pin.svg"
                                                                                loading="lazy" alt="" class="image-13" />
                                                                            <div class="text-block-21"><br /><%= userIsSeeker.getLocation()%>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="div-block-157">

                                                                    <%
                                                                        HirerDTO loginUser = (HirerDTO) session.getAttribute("USER_LOGIN");
                                                                        ProjectDAO projectDao = new ProjectDAO();
                                                                        List<ProjectDTO> listProjectUnactive = projectDao.getListProjectUnactive(loginUser.getHirerID());

                                                                    %>
                                                                    <form action="MainController" method="get">
                                                                        <select class="ui selection dropdown" style="margin-right: 20px;" name="projectID" required>
                                                                            <option selected class="default text">Choose the project ...</option>
                                                                            <%if (listProjectUnactive != null) {
                                                                                    if (!listProjectUnactive.isEmpty()) {
                                                                                        for (ProjectDTO elem : listProjectUnactive) {

                                                                            %>
                                                                            <option value=<%=elem.getProjectID()%>><%=elem.getProjectName()%></option>
                                                                            <%}
                                                                                    }
                                                                                }%>
                                                                        </select>



                                                                        <input type="hidden" name="seekerID" value="<%=seeker.getSeekerID()%>"/>
                                                                        <input data-w-id="21656960-52d5-5f8e-04ae-05ab3a417c65"
                                                                                
                                                                               class="main-button invite w-button"
                                                                               type = "submit" name ="action"
                                                                               onclick = "return confirm('Do you confirm to invite?');"
                                                                               value = "InviteSeeker">



                                                                    </form>

                                                                </div>
                                                            </div>
                                                            <div class="seeker-main-content-wrapper">
                                                                <div class="div-30 border-right padding-top-bottom d-none">
                                                                    <div class="seeker-left-inforwrapper">
                                                                        <div class="div-horizon spacing-between">
                                                                            <div class="text-block-23">Hours per week </div>
                                                                        </div>
                                                                        <div class="text-block-seeker">More than 30
                                                                            hrs/week<br /></div>
                                                                    </div>
                                                                    <div class="seeker-left-inforwrapper">
                                                                        <div class="div-horizon spacing-between">
                                                                            <div class="text-block-23">Language</div>
                                                                        </div>
                                                                        <div class="text-block-seeker"><strong>English:
                                                                            </strong>Native or Bilingual<br /></div>
                                                                    </div>
                                                                    <div class="seeker-left-inforwrapper">
                                                                        <div class="div-horizon spacing-between">
                                                                            <div class="text-block-23">Education <br />
                                                                            </div>
                                                                        </div>
                                                                        <div><strong>FPT University</strong></div>
                                                                        <div class="text-block-seeker">Bachelor&#x27;s
                                                                            degree, Software Engineering<br /></div>
                                                                    </div>
                                                                </div>
                                                                <div class="div-70 full-with">
                                                                    <div class="seeker-right-information-wrapper">
                                                                        <div class="div-horizon space-between">
                                                                            <div class="div-horizon _60">
                                                                                <h1 class="heading-tittle"><%=seeker.getTitileBio()%>
                                                                                    <br /></h1>
                                                                            </div>
                                                                            <div>
                                                                                <div class="div-horizon _20">
                                                                                    <h3><strong
                                                                                            class="bold-text-2">$<%=seeker.getMoneyPerHour()%>/hr</strong>
                                                                                    </h3>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="div-horizon">
                                                                            <div class="my-bio"><%= seeker.getMajor()%></div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="seeker-right-information-wrapper">
                                                                        <div class="div-horizon space-between">
                                                                            <h1 class="heading-tittle">Skills<br /></h1>
                                                                            <div class="seeker-edit-lightbox skill">
                                                                                <div class="seeker-edit-lb-wrapper skills">
                                                                                    <div class="lb-heading">
                                                                                        <h2 class="heading-15">Edit Skills
                                                                                        </h2><img
                                                                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                                                                            loading="lazy"
                                                                                            data-w-id="21656960-52d5-5f8e-04ae-05ab3a417cbe"
                                                                                            alt="" class="image-14" />
                                                                                    </div>
                                                                                    <div class="lb-form-edit-wrapper">
                                                                                        <div class="w-form">
                                                                                            <form id="email-form"
                                                                                                  name="email-form"
                                                                                                  data-name="Email Form"
                                                                                                  method="get"
                                                                                                  class="edit-lightbox-form">
                                                                                                <div><strong>Skills</strong>
                                                                                                </div>
                                                                                                <div class="text-block-29">
                                                                                                    Keeping your skills up
                                                                                                    to date helps you get
                                                                                                    the jobs you want.<br />
                                                                                                </div>
                                                                                                <div
                                                                                                    class="checkbox-skill-wrapper">
                                                                                                    <label
                                                                                                        class="w-checkbox check-box-skill-element">
                                                                                                        <div
                                                                                                            class="w-checkbox-input w-checkbox-input--inputType-custom checkbox">
                                                                                                        </div><input
                                                                                                            type="checkbox"
                                                                                                            name="skill-2"
                                                                                                            id="skill-2"
                                                                                                            data-name="Skill 2"
                                                                                                            style="opacity:0;position:absolute;z-index:-1" /><span
                                                                                                            class="checkbox-label w-form-label"
                                                                                                            for="skill-2">Skill</span>
                                                                                                    </label></div>
                                                                                                <div
                                                                                                    class="lb-edit-button-wrapper">
                                                                                                    <a data-w-id="21656960-52d5-5f8e-04ae-05ab3a417cce"
                                                                                                       href="#"
                                                                                                       class="main-button sub-button seeker-lb w-button">Cancel</a><input
                                                                                                       type="submit"
                                                                                                       value="Save"
                                                                                                       data-wait="Please wait..."
                                                                                                       class="main-button w-button" />
                                                                                                </div>
                                                                                            </form>
                                                                                            <div class="w-form-done">
                                                                                                <div>Thank you! Your
                                                                                                    submission has been
                                                                                                    received!</div>
                                                                                            </div>
                                                                                            <div class="w-form-fail">
                                                                                                <div>Oops! Something went
                                                                                                    wrong while submitting
                                                                                                    the form.</div>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div data-w-id="21656960-52d5-5f8e-04ae-05ab3a417cd7"
                                                                                     class="close-lb-div"></div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="div-horizon">
                                                                            <%for (SkillDTO skill : listSkillOfSeeker) {
                                                                            %>
                                                                            <div class="seeker-skill"><%= skill.getSkillName()%></div>
                                                                            <%
                                                                                }
                                                                            %>


                                                                        </div>
                                                                    </div>
                                                                    <div class="seeker-right-information-wrapper no-border">
                                                                        <h1 class="heading-tittle">Work History<br /></h1>
                                                                        <div class="div-vertical">
                                                                            <%
                                                                                ProposalDAO proposalDao = new ProposalDAO();
                                                                                List<ProposalDTO> listProposal = proposalDao.getHistoryProject(seeker.getSeekerID());
                                                                                if (listProposal.isEmpty()) {
                                                                            %>

                                                                            <div class="text-block-seeker">No work yet. Once
                                                                                you start getting hired on Upwork, your work
                                                                                with clients will show up here.</div>

                                                                            <%
                                                                            } else {

                                                                                for (ProposalDTO proposal : listProposal) {
                                                                                    String comment = proposal.getClientComment();
                                                                                    if (comment == null) {
                                                                                        comment = "";
                                                                                    }

                                                                            %>

                                                                            <div class="job-history-wrapper">
                                                                                <div class="job-history-element">
                                                                                    <div class="history-left">
                                                                                        <h4 class="heading-18"><%=proposal.getProjectName()%></h4>
                                                                                        <div><%=proposal.getStartTime()%> - <%=proposal.getEndTime()%></div>
                                                                                        <!--                                                                                        <div class="no-feedback">If no
                                                                                                                                                                                    feedback: No feedback</div>-->

                                                                                        <div class="review-feedback"><%=comment%></div>
                                                                                        <div class="review-stars-wrapper">
                                                                                            <img loading="lazy"
                                                                                                 src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d915178de70c73cbd8e23_star.png"
                                                                                                 alt="" />
                                                                                            <div> <%= proposal.getSeekerGrade()%>/5 points</div>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="history-right">
                                                                                        <h4 class="heading-17"><%=proposal.getDurationText()%></h4>
                                                                                        <div class="text-block-30">$<%=seeker.getMoneyPerHour()%> / h
                                                                                        </div>
                                                                                        <div class="text-block-30">$<%= proposal.getPaymentAmount()%>
                                                                                            earned</div>
                                                                                    </div>
                                                                                </div>

                                                                            </div>
                                                                            <%
                                                                                    }
                                                                                }
                                                                            %>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="testimonial-session lb">
                                                        <div class="seeker-header-div testimonial">
                                                            <h1 class="heading-tittle">Testimonials</h1>
                                                            <div class="text-block-seeker sub-heading">Endorsements from
                                                                past clients<br /></div>
                                                        </div>
                                                        <div class="testimonial-wrapper">
                                                            <div class="testimonial-element">
                                                                <p class="paragraph-2">&quot;Lorem ipsum dolor sit amet,
                                                                    consectetur adipiscing elit. Suspendisse varius enim in
                                                                    eros elementum tristique. Duis cursus, mi quis viverra
                                                                    ornare, eros dolor interdum nulla, ut commodo diam
                                                                    libero vitae erat. Aenean faucibus nibh et justo cursus
                                                                    id rutrum lorem imperdiet. Nunc ut sem vitae risus
                                                                    tristique posuere&quot;</p><img
                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629b3411c703f3ae535bae02_quote%20Icon.svg"
                                                                    loading="lazy" width="34" alt="" class="image-16" />
                                                            </div>
                                                            <div class="div-horizon"><imgs
                                                                    loading="lazy"
                                                                    sizes="100vw" alt="" class="image-15" />
                                                                <div class="div-vertical">
                                                                    <h4 class="heading-19">Ecommerce Director - Lazada</h4>
                                                                    <div class="text-block-31">Tittle Project: Data
                                                                        Scientist predict man</div>
                                                                    <div class="text-block-32">April 2021</div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%       }
                                                }
                                            }
                                        %>


                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=628aea177e2bdc5cebb3b655"
                type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
        <script src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/js/webflow.a137a3cbc.js"
        type="text/javascript"></script>
        <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
    </body>

</html>