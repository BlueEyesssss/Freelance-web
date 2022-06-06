<%@page import="sample.proposal.ProposalDTO"%>
<%@page import="sample.project.ProjectDTO"%>
<%@page import="sample.user.UserDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="sample.skill.SkillDTO"%>
<%@page import="sample.seeker.SeekerDTO"%>
<%@page import="sample.seeker.SeekerDTO"%>
<!DOCTYPE html>
<html data-wf-page="6296b69f7f3f296ebff1f241"
      data-wf-site="628aea177e2bdc5cebb3b655" data-wf-status="1">

    <head>
        <meta charset="utf-8" />
        <title>Seeker Profile</title>
        <meta content="Seeker Profile" property="og:title" />
        <meta content="Seeker Profile" property="twitter:title" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Webflow" name="generator" />
        <link href="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/css/upwork-7e964a.webflow.cbf98fd52.css"
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
            .w-webflow-badge{
                display: none !important;
            }
        </style>
    </head>

    <body class="user-body">
        <%
            SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN");
        %>
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
                                <div class="text-block-22">Find Work</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="#"
                                                                            class="dropdown-link-nav w-dropdown-link">Find Work</a><a href="#"
                                                                            class="dropdown-link-nav w-dropdown-link">Save Jobs</a><a href="MainController?action=ViewProposal"
                                                                            class="dropdown-link-nav w-dropdown-link">Proposals</a></nav>
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
                                    src="<%= seeker.getAvatar()%>"
                                    loading="lazy" width="90"
                                    sizes="(max-width: 479px) 100vw, (max-width: 767px) 25.4296875px, 6vw"
                                    srcset="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n-p-500.jpeg 500w, <%= seeker.getAvatar()%> 960w"
                                    alt="" class="avatar-img-nav" /></div>
                            <nav class="dropdown-list w-dropdown-list"><a href="#" class="dropdown-link w-dropdown-link">My
                                    Profile</a><a href="MainController?action=Logout" class="dropdown-link w-dropdown-link">Log out</a></nav>
                        </div>
                    </div>
                </div>
                <div class="menu-button w-nav-button">
                    <div class="w-icon-nav-menu"></div>
                </div>
            </div>
        </div>
        <div class="section-2 wf-section">
            <div class="container-90 w-container">
                <div class="main-information-wrapper">
                    <div class="seeker-header-div">
                        <div class="seeker-header-div-left"><img
                                src="<%= seeker.getAvatar()%>"
                                loading="lazy" sizes="(max-width: 479px) 100vw, 110px"
                                srcset="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n-p-500.jpeg 500w, <%= seeker.getAvatar()%> 960w"
                                alt="" class="image-12" />
                            <div>
                                <h1 class="heading-14"><%= seeker.getFullName()%></h1>
                                <div class="div-block-28"><img
                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6296c1f76519c0d7c2b00673_map-pin.svg"
                                        loading="lazy" alt="" class="image-13" />
                                    <div class="text-block-21"><br /><%= seeker.getLocation()%></div>
                                </div>
                            </div>
                        </div>
                        <div class="seeker-header-div-right"><a data-w-id="53ddaa40-1c26-331c-160f-a12e87ea31d7" href="#"
                                                                class="main-button w-button">Change password</a>
                            <div class="seeker-edit-lightbox password">
                                <div data-w-id="04fb8490-9608-6320-7985-aa7a3aac9cc1" class="close-lb-div"></div>
                                <div class="seeker-edit-lb-wrapper password">
                                    <div class="lb-heading">
                                        <h2 class="heading-15">Change password</h2><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                            loading="lazy" data-w-id="04fb8490-9608-6320-7985-aa7a3aac9cc6" alt=""
                                            class="image-14" />
                                    </div>
                                    <div class="lb-form-edit-wrapper">
                                        <div class="w-form">
                                            <form id="email-form" name="email-form" data-name="Email Form" method="get" action="MainController"
                                                  class="edit-lightbox-form">
                                                <div class="div-vertical">
                                                    <div class="div-vertical _w-80">
                                                        <div class="text-block-33">Current password</div>
                                                        <input value=""
                                                               type="password" class="text-field-4 password w-input"
                                                               maxlength="256" name="currentPassword"
                                                               data-name="currentPassword" placeholder="" id="currentPassword"
                                                               required="" />
                                                        <font style="color: red">${requestScope.ERROR_CREATE.passwordNotCorrect}</font>
                                                    </div>
                                                    <div class="div-vertical _w-80">
                                                        <div class="text-block-33">New password</div>
                                                        <input type="password"
                                                               class="text-field-4 password w-input" maxlength="256"
                                                               name="newpassword" data-name="newpassword" placeholder=""
                                                               id="newpassword" required="" />
                                                        <font style="color: red">${requestScope.ERROR_CREATE.password}</font>
                                                    </div>
                                                    <div class="div-vertical _w-80">
                                                        <div class="text-block-33">Confirm password</div>
                                                        <input
                                                            type="password" class="text-field-4 password w-input"
                                                            maxlength="256" name="confirmpassword"
                                                            data-name="confirmpassword" placeholder="" id="confirmpassword"
                                                            required="" />
                                                        <font style="color: red">${requestScope.ERROR_CREATE.confirm}</font>
                                                    </div>
                                                </div>
                                                <div class="lb-edit-button-wrapper">
                                                    <a
                                                        data-w-id="04fb8490-9608-6320-7985-aa7a3aac9cd1" href="#"
                                                        class="main-button sub-button seeker-lb w-button">Cancel</a>
                                                    <input
                                                        type="submit" value="Save Password" name="action" data-wait="Please wait..."
                                                        class="main-button w-button" />
                                                </div>
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
                    <div class="seeker-main-content-wrapper">
                        <div class="div-30 border-right padding-top-bottom">
                            <div class="seeker-left-inforwrapper">
                                <div class="div-horizon spacing-between">
                                    <div class="text-block-23">Hours per week </div><img
                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62972cb6f2d88ab16b24b133_clarity_edit-solid.svg"
                                        loading="lazy" data-w-id="938ebf8c-f85e-1e97-cb3c-3f2f9e195b0b" alt=""
                                        class="icon-edit" />
                                    <div class="seeker-edit-lightbox hourperweek">
                                        <div class="seeker-edit-lb-wrapper">
                                            <div class="lb-heading">
                                                <h2 class="heading-15">Hours per week</h2><img
                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                                    loading="lazy" data-w-id="21993528-1bc8-45e1-52a2-0772430dfca1" alt=""
                                                    class="image-14" />
                                            </div>
                                            <div class="lb-form-edit-wrapper">
                                                <div class="w-form">
                                                    <form id="email-form" name="email-form" data-name="Email Form"
                                                          method="get" class="edit-lightbox-form" action="MainController">
                                                        <div class="text-block-25">Knowing how much you can work helps
                                                            Collab find the right jobs for you.</div>
                                                        <label
                                                            class="field-label-2">I can currently work<br /></label>

                                                        <label class="radio-button-field-3 w-radio">
                                                            <input type="radio" name="hourPerWeek" id="More-than-30-hrs-week"
                                                                   value="More than 30 hrs/week" data-name="workingHour"
                                                                   required=""
                                                                   class="w-form-formradioinput w-radio-input" />
                                                            <span
                                                                class="w-form-label" for="More-than-30-hrs-week">More than
                                                                30 hrs/week<br /></span>
                                                        </label>

                                                        <label
                                                            class="radio-button-field-3 w-radio"><input type="radio"
                                                                                                    name="hourPerWeek" id="Less-than-30-hrs-week"
                                                                                                    value="Less than 30 hrs/week" data-name="workingHour"
                                                                                                    class="w-form-formradioinput w-radio-input" />
                                                            <span
                                                                class="w-form-label" for="Less-than-30-hrs-week">Less than
                                                                30 hrs/week<br /></span>
                                                        </label>

                                                        <label
                                                            class="radio-button-field-3 w-radio">
                                                            <input type="radio"
                                                                   name="hourPerWeek" id="As-needed---open-to-offers"
                                                                   value="As needed - open to offers" data-name="workingHour"
                                                                   class="w-form-formradioinput w-radio-input" />
                                                            <span
                                                                class="w-form-label" for="As-needed---open-to-offers">As
                                                                needed - open to offers<br /></span>
                                                        </label>

                                                        <label
                                                            class="radio-button-field-3 w-radio">
                                                            <input type="radio"
                                                                   name="hourPerWeek" id="None" value="None"
                                                                   data-name="workingHour"
                                                                   class="w-form-formradioinput w-radio-input" />
                                                            <span
                                                                class="w-form-label" for="None">None</span>
                                                        </label>
                                                        <div class="lb-edit-button-wrapper">
                                                            <a
                                                                data-w-id="6c6e52ad-360e-7c57-e874-39f1af237e44" href="#"
                                                                class="main-button sub-button seeker-lb w-button">Cancel</a>

                                                            <input
                                                                type="submit" value="Save Hour Per Week" data-wait="Please wait..."
                                                                class="main-button w-button" name="action"/>
                                                        </div>
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
                                        <div data-w-id="971ed25c-7e83-0169-54b2-9e91d3a56eac" class="close-lb-div"></div>
                                    </div>
                                </div>
                                <div class="text-block-seeker"><%= seeker.getHourPerWeek()%><br /></div>
                            </div>
                            <div class="seeker-left-inforwrapper">
                                <div class="div-horizon spacing-between">
                                    <div class="text-block-23">Language</div>
                                    <div class="seeker-edit-lightbox language">
                                        <div class="seeker-edit-lb-wrapper">
                                            <div class="lb-heading">
                                                <h2 class="heading-15">Edit languages</h2><img
                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                                    loading="lazy" data-w-id="2429e3ac-9328-3e75-e03b-9c0ad29687b9" alt=""
                                                    class="image-14" />
                                            </div>
                                            <div class="lb-form-edit-wrapper">
                                                <div class="w-form">
                                                    <form id="email-form" name="email-form" data-name="Email Form" 
                                                          method="get" class="edit-lightbox-form" action="MainController">
                                                        <div class="lb-edit-button-wrapper">
                                                            <a
                                                                data-w-id="2429e3ac-9328-3e75-e03b-9c0ad29687d6" href="#"
                                                                class="main-button sub-button seeker-lb w-button">Cancel</a>

                                                            <input
                                                                type="submit" value="Save Language Level" name="action" data-wait="Please wait..." 
                                                                class="main-button w-button" />
                                                        </div>
                                                        <div class="div-horizon space-between">
                                                            <label for="language-3"
                                                                   class="field-label-3">English</label>
                                                            <select id="language-3"
                                                                    name="languagelv" data-name="language" required=""
                                                                    class="select-field w-select">
                                                                <option value="Basic">Basic</option>
                                                                <option value="Conversational">Conversational</option>
                                                                <option value="Fluent">Fluent</option>
                                                                <option value="Native or Bilingual">Native or Bilingual</option>
                                                            </select>
                                                        </div>
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
                                        <div data-w-id="f2b051cd-ca90-680d-81dd-7a65b7b27ac1" class="close-lb-div"></div>
                                    </div><img
                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62972cb6f2d88ab16b24b133_clarity_edit-solid.svg"
                                        loading="lazy" data-w-id="f441bf14-03b2-ab52-d3de-43b8583cfacb" alt=""
                                        class="icon-edit" />
                                </div>
                                <div class="text-block-seeker"><strong><%= seeker.getLanguage()%>: </strong><%= seeker.getLanguagelv()%><br /></div>
                            </div>
                            <div class="seeker-left-inforwrapper">
                                <div class="div-horizon spacing-between">
                                    <div class="text-block-23">Education <br /></div><img
                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62972cb6f2d88ab16b24b133_clarity_edit-solid.svg"
                                        loading="lazy" data-w-id="ba73fb29-3766-f350-efa3-0ec67e3208ad" alt=""
                                        class="icon-edit" />
                                    <div class="seeker-edit-lightbox education">
                                        <div class="seeker-edit-lb-wrapper education">
                                            <div class="lb-heading">
                                                <h2 class="heading-15">Education</h2><img
                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                                    loading="lazy" data-w-id="ba73fb29-3766-f350-efa3-0ec67e3208b6" alt=""
                                                    class="image-14" />
                                            </div>
                                            <div class="lb-form-edit-wrapper">
                                                <div class="w-form">
                                                    <form id="email-form" name="email-form" data-name="Email Form" action="MainController"
                                                          method="get" class="edit-lightbox-form">
                                                        <div class="lb-edit-button-wrapper">
                                                            <a
                                                                data-w-id="ba73fb29-3766-f350-efa3-0ec67e3208d3" href="#"
                                                                class="main-button sub-button seeker-lb w-button">Cancel</a>
                                                            <input name="action"
                                                                   type="submit" value="Save Academic level" data-wait="Please wait..."
                                                                   class="main-button w-button" />
                                                        </div>
                                                        <div>
                                                            <label for="education"><strong>School</strong></label>
                                                            <input
                                                                type="text" class="text-field-3 w-input" maxlength="256"
                                                                name="education" value="<%= seeker.getEducation()%>" data-name="university"
                                                                placeholder="University of People" id="university"
                                                                required="" />

                                                            <label for="degree"><strong>Degree</strong></label>
                                                            <select id="degree" name="degree"
                                                                    data-name="degree" class="select-field-4 w-select">
                                                                <option value="None">None</option>
                                                                <option value="College degree">College degree</option>
                                                                <option value="University degree">University degree</option>
                                                                <option value="Master's degree">Master's degree</option>
                                                            </select>

                                                            <label for="major"><strong>Area of Study(Optional)</strong></label>
                                                            <input type="text"
                                                                   class="w-input" maxlength="256" name="major" value="<%= seeker.getMajor()%>"
                                                                   data-name="major" placeholder="Software Engineer" id="major"
                                                                   required="" />
                                                        </div>
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
                                        <div data-w-id="079b63d9-bb54-5ffb-4adf-c1a259c4de97" class="close-lb-div"></div>
                                    </div>
                                </div>
                                <div><strong><%= seeker.getEducation()%></strong></div>
                                <div class="text-block-seeker"><%= seeker.getDegree()%>, <%= seeker.getMajor()%><br /></div>
                            </div>
                        </div>
                        <div class="div-70">
                            <div class="seeker-right-information-wrapper">
                                <div class="div-horizon space-between">
                                    <div class="div-horizon _60">
                                        <h1 class="heading-tittle"><%= seeker.getTitileBio()%>
                                            <br /></h1><img
                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62972cb6f2d88ab16b24b133_clarity_edit-solid.svg"
                                            loading="lazy" data-w-id="cb3c3c4b-e085-f57a-bfca-cadac756d413" alt=""
                                            class="icon-edit" />
                                        <div class="seeker-edit-lightbox tittle">
                                            <div data-w-id="18f62774-f11f-8f62-154d-f46453bc8600" class="close-lb-div">
                                            </div>
                                            <div class="seeker-edit-lb-wrapper">
                                                <div class="lb-heading">
                                                    <h2 class="heading-15">Edit your title</h2><img
                                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                                        loading="lazy" data-w-id="841e3707-ccc3-2999-1ca6-14a7bb0d8ed6"
                                                        alt="" class="image-14" />
                                                </div>
                                                <div class="lb-form-edit-wrapper">
                                                    <div class="w-form">
                                                        <form id="email-form" name="email-form" data-name="Email Form" action="MainController"
                                                              method="get" class="edit-lightbox-form">
                                                            <div class="div-vertical">
                                                                <label for="Language-3"
                                                                       class="field-label-3">Tittle</label>
                                                                <div class="text-block-27">Enter a single sentence
                                                                    description of your professional skills/experience (e.g.
                                                                    Expert Web Designer with Ajax experience)
                                                                </div>
                                                                <input
                                                                    type="text" class="text-field-4 w-input" maxlength="256"
                                                                    name="titileBio" value="<%= seeker.getTitileBio()%>" data-name="tittle"
                                                                    placeholder="Enter your tittle" id="tittle"
                                                                    required="" />
                                                                ${requestScope.ERROR_UPDATE_INF_SEEKER}
                                                            </div>
                                                            <div class="lb-edit-button-wrapper">
                                                                <a
                                                                    data-w-id="841e3707-ccc3-2999-1ca6-14a7bb0d8edb"
                                                                    href="#"
                                                                    class="main-button sub-button seeker-lb w-button">Cancel</a>
                                                                <input
                                                                    type="submit" name="action" value="Save Title" data-wait="Please wait..."
                                                                    class="main-button w-button" />
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
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="div-horizon _20">
                                            <h3><strong class="bold-text-2">$<%= seeker.getMoneyPerHour()%>/hr</strong></h3><img
                                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62972cb6f2d88ab16b24b133_clarity_edit-solid.svg"
                                                loading="lazy" data-w-id="60c46bdf-aef3-57f8-84fb-2dd50b188d49" alt=""
                                                class="icon-edit hour-rate" />
                                            <div class="seeker-edit-lightbox hour-rate">
                                                <div class="seeker-edit-lb-wrapper">
                                                    <div class="lb-heading">
                                                        <h2 class="heading-15">Edit your Hour Rate</h2><img
                                                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                                            loading="lazy" data-w-id="238c6d0a-eefb-ea63-a37d-b1661d121f86"
                                                            alt="" class="image-14" />
                                                    </div>
                                                    <div class="lb-form-edit-wrapper">
                                                        <div class="w-form">
                                                            <form id="email-form" name="email-form" data-name="Email Form" action="MainController"
                                                                  method="get" class="edit-lightbox-form">
                                                                <div class="div-vertical"><label for="Language-4"
                                                                                                 class="field-label-3">Hour Rate</label>
                                                                    <div class="text-block-27">Please note that your new
                                                                        hourly rate will only apply to new contracts.</div>
                                                                    <div class="div-horizon _w-100 h-100 space-between">
                                                                        <div>
                                                                            <div><strong>Hourly Rate</strong><br /></div>
                                                                            <div>Total amount the client will see</div>
                                                                        </div>
                                                                        <div class="div-horizon _w-50 pad-20">
                                                                            <div class="hour-rate-input-wrapper">
                                                                                <img
                                                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629423f2cd8d721f22e4bafb_moeny.png"
                                                                                    loading="lazy" alt="" />
                                                                                <input
                                                                                    type="number" class="text-field-5 w-input"
                                                                                    maxlength="256" name="moneyPerHour" value="<%= seeker.getMoneyPerHour()%>"
                                                                                    data-name="hourRate" placeholder="12" min="0"
                                                                                    id="hourRate" required="" />
                                                                            </div>
                                                                            <div>/hr</div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                ${requestScope.ERROR_UPDATE_INF_SEEKER}
                                                                <div class="lb-edit-button-wrapper">
                                                                    <a
                                                                        data-w-id="238c6d0a-eefb-ea63-a37d-b1661d121f91"
                                                                        href="#"
                                                                        class="main-button sub-button seeker-lb w-button">Cancel</a>
                                                                    <input
                                                                        type="submit" value="Save Hour Rate" name="action"
                                                                        data-wait="Please wait..."
                                                                        class="main-button w-button" />
                                                                </div>
                                                            </form>
                                                            <div class="w-form-done">
                                                                <div>Thank you! Your submission has been received!</div>
                                                            </div>
                                                            <div class="w-form-fail">
                                                                <div>Oops! Something went wrong while submitting the form.
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div data-w-id="4231faa1-e1ae-faa4-fdf2-a4610b026b69" class="close-lb-div">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="div-horizon">
                                    <div class="my-bio"><%= seeker.getOverview()%>
                                    </div><img
                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62972cb6f2d88ab16b24b133_clarity_edit-solid.svg"
                                        loading="lazy" data-w-id="26dc12a6-71cb-d054-39eb-b11436d77b91" alt=""
                                        class="icon-edit hour-rate" />
                                    <div class="seeker-edit-lightbox bio">
                                        <div class="seeker-edit-lb-wrapper overview">
                                            <div class="lb-heading">
                                                <h2 class="heading-15">Overview</h2><img
                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                                    loading="lazy" data-w-id="bd308e16-273c-1240-339c-0654c6fc7af7" alt=""
                                                    class="image-14" />
                                            </div>
                                            <div class="lb-form-edit-wrapper">
                                                <div class="w-form">
                                                    <form id="email-form" name="email-form" data-name="Email Form" action="MainController"
                                                          method="get" class="edit-lightbox-form">
                                                        <div class="div-vertical"><label for="Language-4"
                                                                                         class="field-label-3">Tittle</label>
                                                            <div class="text-block-28">Use this space to show clients you
                                                                have the skills and experience they&#x27;re looking for.
                                                            </div>
                                                            <ul role="list">
                                                                <li>Describe your strengths and skills<br /></li>
                                                                <li>Highlight projects, accomplishments and education<br />
                                                                </li>
                                                                <li>Keep it short and make sure it&#x27;s error-free</li>
                                                            </ul>
                                                            <textarea
                                                                placeholder="overview" type="text"
                                                                maxlength="5000" id="overview" name="overview" value="<%= seeker.getOverview()%>"
                                                                data-name="field" class="textarea w-input"></textarea>
                                                            ${requestScope.ERROR_UPDATE_INF_SEEKER}
                                                        </div>
                                                        <div class="lb-edit-button-wrapper">
                                                            <a
                                                                data-w-id="bd308e16-273c-1240-339c-0654c6fc7b02" href="#"
                                                                class="main-button sub-button seeker-lb w-button">Cancel</a>
                                                            <input
                                                                type="submit" value="Save Overview" data-wait="Please wait..." name="action"
                                                                class="main-button w-button" />
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
                                            <div data-w-id="318a3a28-35a7-13be-6d80-f8e055ef5189" class="close-lb-div">
                                            </div>
                                        </div>
                                        <div data-w-id="67a5bfec-6101-2535-3cc2-3bfbc0c5e4a0" class="close-lb-div"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="seeker-right-information-wrapper">
                                <h1 class="heading-tittle">Work History<br /></h1>
                                <div class="div-vertical">     
                                    <%            List<ProposalDTO> listHistoryProject = (List<ProposalDTO>) request.getAttribute("LIST_HISTORY_PROJECT");
                                        if (listHistoryProject != null) {
                                            if (listHistoryProject.size() > 0) {
                                                for (ProposalDTO proposal : listHistoryProject) {
                                    %>

                                    <div class="job-history-wrapper">
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
                                                <div class="text-block-30">$200 earned</div>
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
                            <div class="seeker-right-information-wrapper">
                                <div class="div-horizon space-between">
                                    <h1 class="heading-tittle">Skills<br /></h1><img
                                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/62972cb6f2d88ab16b24b133_clarity_edit-solid.svg"
                                        loading="lazy" data-w-id="c9c964b7-625f-b84a-adad-da38f21fb54f" alt=""
                                        class="icon-edit" />
                                    <div class="seeker-edit-lightbox skill">
                                        <div class="seeker-edit-lb-wrapper skills">
                                            <div class="lb-heading">
                                                <h2 class="heading-15">Edit Skills</h2><img
                                                    src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/629730e1c2204bda6f0f70bf_x.svg"
                                                    loading="lazy" data-w-id="ddcb0870-bf12-8ad0-90b9-3a89f2741aa8" alt=""
                                                    class="image-14" />
                                            </div>
                                            <div class="lb-form-edit-wrapper">
                                                <div class="w-form">
                                                    <form id="email-form" name="email-form" data-name="Email Form" action="MainController"
                                                          method="get" class="edit-lightbox-form">
                                                        <div><strong>Skills</strong></div>
                                                        <div class="text-block-29">Keeping your skills up to date helps you
                                                            get the jobs you want.<br /></div>
                                                        <div class="checkbox-skill-wrapper">

                                                            <%
                                                                List<SkillDTO> listSkillSeeker = (List<SkillDTO>) session.getAttribute("LIST_SKILL_OF_SEEKER");
                                                                List<SkillDTO> listSkillAll = (List<SkillDTO>) session.getAttribute("LIST_SKILL_ALL");
                                                                for (SkillDTO elem : listSkillAll) {
                                                            %>
                                                            <label
                                                                class="w-checkbox check-box-skill-element">
                                                                <div
                                                                    class="w-checkbox-input w-checkbox-input--inputType-custom checkbox">
                                                                </div>
                                                                <input type="checkbox" name="skillID" id="skill"
                                                                       data-name="skill" value="<%= elem.getSkillID()%>"
                                                                       style="opacity:0;position:absolute;z-index:-1"/>
                                                                <span
                                                                    class="checkbox-label w-form-label" for="skillID"><%= elem.getSkillName()%></span>  
                                                            </label>
                                                            <%
                                                                }
                                                            %>

                                                        </div>
                                                        ${requestScope.CREATE_SKILL_SEEKER_HAS}
                                                        <div class="lb-edit-button-wrapper">
                                                            <a
                                                                data-w-id="ddcb0870-bf12-8ad0-90b9-3a89f2741aad" href="#"
                                                                class="main-button sub-button seeker-lb w-button">Cancel</a>
                                                            <input
                                                                type="submit" value="Save Skill" data-wait="Please wait..." name="action"
                                                                class="main-button w-button" />
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
                                        </div>
                                        <div data-w-id="023781b2-0d1a-137d-6e6c-33172cdc0f5f" class="close-lb-div"></div>
                                    </div>
                                </div>
                                <div class="div-horizon">
                                    <%
                                        for (SkillDTO skill : listSkillSeeker) {
                                    %>
                                    <div class="seeker-skill"><%= skill.getSkillName()%></div>
                                    <%
                                        }
                                    %>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="testimonial-session">
                    <div class="seeker-header-div testimonial">
                        <h1 class="heading-tittle">Testimonials</h1>
                        <div class="text-block-seeker sub-heading">Endorsements from past clients<br /></div>
                    </div>
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