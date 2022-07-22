<%@page import="sample.hirer.HirerDTO"%>
<%@page import="sample.project.ProjectDAO"%>
<%@page import="sample.skill.SkillDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.project.ProjectDTO"%>
<!DOCTYPE html><!-- This site was created in Webflow. http://www.webflow.com -->
<!-- Last Published: Sat Jun 18 2022 05:26:13 GMT+0000 (Coordinated Universal Time) -->
<html data-wf-domain="upwork-7e964a.webflow.io" data-wf-page="6296b682f8b462fb53aec689"
      data-wf-site="628aea177e2bdc5cebb3b655" data-wf-status="1">

    <head>
        <meta charset="utf-8" />
        <title>Proposal</title>
        <meta content="Proposal" property="og:title" />
        <meta content="Proposal" property="twitter:title" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Webflow" name="generator" />
        <link href="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/css/upwork-7e964a.webflow.f4df5d2cc.css"
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
        HirerDTO loginUser = (HirerDTO) session.getAttribute("USER_LOGIN");
        ProjectDTO projectCurrent = (ProjectDTO) request.getAttribute("PROJECT_CURRENT");
        if (projectCurrent != null) {
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
                                <form "id="email-form-2" name="email-form-2" data-name="Email Form 2" method="get"><input
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
                                <div class="text-block-22">Find Work</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list">
                            <a href="postAJob.jsp"
                                class="dropdown-link-nav w-dropdown-link">Post a Job</a>
                                
                            <a href="MainController?action=ViewContractOfHirer"
                                class="dropdown-link-nav w-dropdown-link">All contract</a>
                                
                            <a href="#"
                                class="dropdown-link-nav w-dropdown-link">Hire</a>
                            </nav>
                        </div>
                        <div data-hover="true" data-delay="0" class="link nav-link w-dropdown">
                            <div class="dropdown-toggle-3 w-dropdown-toggle">
                                <div class="text-block-22">My Job</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="#"
                                                                            class="dropdown-link-nav w-dropdown-link">My Job</a><a href="#"
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
                                    src="uploads/<%= loginUser.getAvatar() %>"
                                    loading="lazy" width="90"
                                    sizes="(max-width: 479px) 100vw, (max-width: 767px) 43.134765625px, 6vw"
                                    
                                    alt="" class="avatar-img-nav" /></div>
                            <nav class="dropdown-list w-dropdown-list">
                            
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

        <div class="responsive-section wf-section">
            <div class="container-1200 w-container">
                <h1 class="heading-127">Edit Job post</h1>
                <div class="upwork-element-wrapper padding">
                    <div class="w-form">
                        <form action="MainController"id="email-form-6" name="email-form-6" data-name="Email Form 6" method="get"> 
                            <div class="form-element"><label for="name-2" class="field-label small"><strong>1. Edit the name
                                        of your job jost<strong></strong></strong><br /></label><input type="text"
                                                                                               class="text-field w-input" maxlength="256" name="projectName" 
                                                                                               placeholder="" Value="<%= projectCurrent.getProjectName()%>" id="name-2" /></div>
                            <div class="form-element"><label for="videoSharing" class="field-label small"><strong>2. Edit
                                        the Discription of the job (Not over 5000
                                        words)<strong><br /></strong></strong></label>
                                <div class="html-embed-20 w-embed"><textarea  name="description" id="whyJoin" Value="<%= projectCurrent.getDescription()%>"
                                                                             oninput="countWord()" rows="5"
                                                                             style="width: 100%; padding: 10px; border-color: #caccd1; border-radius: 7px">
                                    </textarea></div>
                                <div class="html-embed-22 w-embed w-script">
                                    <script>
                                        function countWord() {

                                            // Get the input text value
                                            var words = document
                                                    .getElementById("whyJoin").value;

                                            // Initialize the word counter
                                            var count = 0;

                                            // Split the words on each
                                            // space character
                                            var split = words.split(' ');

                                            // Loop through the words and
                                            // increase the counter when
                                            // each split word is not empty
                                            for (var i = 0; i < split.length; i++) {
                                                if (split[i] != "") {
                                                    count += 1;
                                                }
                                            }
                                            if (count > 5000) {
                                                alert('No more than 5000 words, please!');
                                            }

                                            // Display it as output
                                            document.getElementById("show")
                                                    .innerHTML = count;
                                        }
                                    </script>
                                </div>
                                <div class="html-embed-7 w-embed">
                                    <p> Word Count:
                                        <span id="show">0</span>
                                    </p>
                                </div>
                                <div class="div-block-133">
                                    <div>It can be helpful to:</div>
                                    <ul role="list">
                                        <li class="list-item">Explain your project and deliverable(s), as well as problems
                                            to be solved?skilled professionals love a good challenge<br /></li>
                                        <li class="list-item">Describe the type of expertise you?re looking for (i.e. skill
                                            level, type of experience)</li>
                                        <li class="list-item">Highlight anything that?s unique about your project or
                                            organization, such as a compelling mission or use case</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="form-element">
                                <div class="text-block-141"><strong>3. Choose the relevant skill</strong></div>
                                <div class="text-block-142">Highlight relevant skills and the level of expertise you feel
                                    would be ideal.</div>
                                <div class="checkbox-skill-wrapper grid-5">
                                    <%
                                        List<SkillDTO> listSkillAll = (List<SkillDTO>) session.getAttribute("LIST_SKILL_ALL");
                                        for (SkillDTO elem : listSkillAll) {
                                            ProjectDAO dao = new ProjectDAO();
                                            if(dao.checkSkillMatch(elem.getSkillName(), projectCurrent.getListSkill(projectCurrent.getProjectID()))){
                                    %>
                                    <label
                                        class="w-checkbox check-box-skill-element">
                                        <div class="w-checkbox-input w-checkbox-input--inputType-custom checkbox w--redirected-checked"></div>
                                        <input type="checkbox" name="skillID" value="<%= elem.getSkillID()%>" id="skill" data-name="skill"
                                               checked=""
                                               style="opacity:0;position:absolute;z-index:-1" /><span
                                               class="checkbox-label w-form-label" for="Skill"><%= elem.getSkillName()%></span>
                                    </label>
                                    <%
                                        }else{%>
                                    <label
                                        class="w-checkbox check-box-skill-element">
                                        <div class="w-checkbox-input w-checkbox-input--inputType-custom checkbox"></div>
                                        <input type="checkbox" name="skillID" value="<%= elem.getSkillID()%>" id="Skill" data-name="Skill"
                                               style="opacity:0;position:absolute;z-index:-1" /><span
                                               class="checkbox-label w-form-label" for="Skill"><%= elem.getSkillName()%></span>
                                    </label>
                                    
                                    <%
                                               }
                                        }
                                    %>
                                </div>
                            </div>
                            <div class="form-element"><label id="timePerWeek" for="field-2"
                                                             class="field-label small"><strong>4. Major</strong><br /></label><input type="text"
                                                                                                        class="text-field w-input" maxlength="256" name="major" value="<%= projectCurrent.getMajor()%>"
                                                                                                        placeholder="Example Text" id="field-2" required="" /></div>
                            <div class="form-element"><label id="timePerWeek" class="field-label small"><strong>5. Choose
                                        the complexity</strong><br /></label><label class="radio-field small w-radio"><input
                                        type="radio" name="complexity" id="Entry-Level" value="Entry"
                                        data-name="complexity" class="w-form-formradioinput w-radio-input" /><span
                                        for="Entry-Level" class="radio-label-2 small w-form-label">Entry
                                        Level</span></label><label class="radio-field w-radio"><input type="radio"
                                                                                              name="complexity" id="Intermediate-2" value="Intermediate" data-name="complexity"
                                                                                              class="w-form-formradioinput w-radio-input" /><span for="Intermediate-2"
                                                                                              class="radio-label-2 small w-form-label">Intermediate</span></label><label
                                    class="radio-field w-radio"><input type="radio" name="complexity" id="Expert-2"
                                                                   value="Expert" data-name="complexity"
                                                                   class="w-form-formradioinput w-radio-input" /><span for="Expert-2"
                                                                   class="radio-label-2 small w-form-label">Expert</span></label></div>
                            <div class="form-element">
                                <div class="field-label small"><strong>6. Choose the duration</strong></div>
                                <div class="ticket-wrapper edit-grid"><label class="radio-button-field-5 w-radio"><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62a35532cc5e85ef441d1771_clock.svg"
                                            loading="lazy" width="43" alt="" class="form-ticket-img" />
                                        <div
                                            class="w-form-formradioinput w-form-formradioinput--inputType-custom radio-button-2 w-radio-input">
                                        </div><input type="radio" name="durationID" id="Less-than-1-month"
                                                     value="1" data-name="duration"
                                                     style="opacity:0;position:absolute;z-index:-1" /><span
                                                     class="radio-button-label-2 bold w-form-label" for="Less-than-1-month"><span
                                                class="text-span-12">Short-term Job<br /></span><br />Less than 1
                                            month<br /></span>
                                    </label><label class="radio-button-field-5 w-radio"><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62a35532cc5e85ef441d1771_clock.svg"
                                            loading="lazy" width="43" alt="" class="form-ticket-img" />
                                        <div
                                            class="w-form-formradioinput w-form-formradioinput--inputType-custom radio-button-2 w-radio-input">
                                        </div><input type="radio" name="durationID" id="1-to-3-months" value="2"
                                                     data-name="duration" style="opacity:0;position:absolute;z-index:-1" /><span
                                                     class="radio-button-label-2 bold w-form-label" for="1-to-3-months"><span
                                                class="text-span-12">Middle-term Job<br /></span><br />1 - 3
                                            months<br /></span>
                                    </label><label class="radio-button-field-5 w-radio"><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62a3553330f13997b0684fe7_calendar.svg"
                                            loading="lazy" width="33" alt="" class="form-ticket-img" />
                                        <div
                                            class="w-form-formradioinput w-form-formradioinput--inputType-custom radio-button-2 w-radio-input">
                                        </div><input type="radio" name="durationID" id="3-to-6-months" value="3"
                                                     data-name="duration" style="opacity:0;position:absolute;z-index:-1" /><span
                                                     class="radio-button-label-2 bold w-form-label" for="3-to-6-months"><span
                                                class="text-span-12">Long-term job</span><br /><br />3 - 6
                                            months<br /></span>
                                    </label><label class="radio-button-field-5 w-radio"><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62a3553330f13997b0684fe7_calendar.svg"
                                            loading="lazy" width="36" alt="" class="form-ticket-img" />
                                        <div
                                            class="w-form-formradioinput w-form-formradioinput--inputType-custom radio-button-2 w-radio-input">
                                        </div><input type="radio" name="durationID" id="More-than-6-months"
                                                     value="More than 6 months" data-name="duration"
                                                     style="opacity:0;position:absolute;z-index:-1" /><span
                                                     class="radio-button-label-2 bold w-form-label" for="4"><span
                                                class="text-span-12">Long term job<br />?</span><br />More than 6
                                            months<br /></span>
                                    </label></div>
                            </div>
                            <div class="form-element"><label id="timePerWeek" class="field-label small"><strong>7. Fill the
                                        budget</strong><br /></label>
                                <div class="hour-rate-input-wrapper budget _w-50"><img
                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629423f2cd8d721f22e4bafb_moeny.png"
                                        loading="lazy" alt="" /><input type="text"
                                        class="text-field-5 budget _w-100 w-input" maxlength="256" name="budget"
                                        value="<%= projectCurrent.getPaymentAmount()%>" placeholder="12" id="Budget-4" required="" /></div>
                            </div>
                            <div class="form-element"><label id="timePerWeek" for="Deadline-3"
                                                             class="field-label small"><strong>8. Deadline</strong><br /></label><input type="date"
                                                                                                           class="text-field _w-50 w-input" maxlength="256" name="deadline" value="<%= projectCurrent.getDeadlineDate()%>" 
                                                                                                           placeholder="Type date nha" id="Deadline-3" required="" /></div>
                            <div class="form-element"><label for="location" class="field-label small"><strong
                                        class="bold-text-78">9. Location</strong></label><input type="text"
                                                                                        class="text-field edit w-input" maxlength="256" name="location" data-name="<%= projectCurrent.getLocation()%>" value="<%= projectCurrent.getLocation()%>"
                                                                                        placeholder="" id="location" /></div>
                            <input type="hidden" name="projectID" value="<%= projectCurrent.getProjectID()%>"/>
                            <input type="submit" value="Save Edit" name="action"
                                   data-wait="Please wait..." class="main-button w-button" />
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

        <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=628aea177e2bdc5cebb3b655"
                type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
        <script src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/js/webflow.e56a43cd3.js"
        type="text/javascript"></script>
        <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
    </body>
    <%
        }
    %>
</html>