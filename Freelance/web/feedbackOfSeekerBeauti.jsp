<%@page import="java.time.LocalDate"%>
<%@page import="sample.user.UserDTO"%>
<%@page import="sample.user.UserDAO"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.AALOAD"%>
<%@page import="sample.hirer.HirerDTO"%>
<%@page import="sample.hirer.HirerDAO"%>
<%@page import="sample.project.ProjectDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.project.ProjectDAO"%>
<%@page import="sample.proposal.ProposalDTO"%>
<!DOCTYPE html><!-- This site was created in Webflow. https://www.webflow.com -->
<!-- Last Published: Thu Jul 21 2022 07:38:06 GMT+0000 (Coordinated Universal Time) -->
<html data-wf-domain="phats-sublime-site.webflow.io" data-wf-page="62d7f76293a2ee414cd1e5b1"
  data-wf-site="62d7f76293a2ee4589d1e5b0">

<head>
  <meta charset="utf-8" />
  <title>Phát&#x27;s Sublime Site</title>
  <meta content="width=device-width, initial-scale=1" name="viewport" />
  <meta content="Webflow" name="generator" />
  <link href="https://uploads-ssl.webflow.com/62d7f76293a2ee4589d1e5b0/css/phats-sublime-site.webflow.bdb63e7ba.css"
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
    ProposalDTO proposal = (ProposalDTO)request.getAttribute("PROPOSAL");
    ProjectDAO dao = new ProjectDAO();
    ProjectDTO project = dao.getProjectByID(proposal.getProjectID());
    List<String> skillneed = dao.getSkillNeedOfProject(project.getProjectID());
                    project.setSkillneed(skillneed);
    if(proposal!= null){
        %>
<body class="body">
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
              <form id="email-form-2" name="email-form-2" data-name="Email Form 2" method="get"><input type="text"
                  class="search-input-2 w-input" maxlength="256" name="name-2" data-name="Name 2" placeholder=""
                  id="name-2" /><input type="submit" value="Submit" data-wait="Please wait..."
                  class="submit-button-2 w-button" /></form>
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
              <div class="text-block-22">Find Work</div>
            </div>
            <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewSeekerDashboard" class="dropdown-link-nav w-dropdown-link">Find
                Work</a><a href="MainController?action=ViewProposal" class="dropdown-link-nav w-dropdown-link">Proposals</a></nav>
          </div>
          <div data-hover="true" data-delay="0" class="link-4 nav-link w-dropdown">
            <div class="dropdown-toggle-3 w-dropdown-toggle">
              <div class="text-block-22">My Job</div>
            </div>
            <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewMyJob"
                class="dropdown-moi-qua-troi-moi w-dropdown-link">My Job</a>
                <a href="MainController?action=ViewContract"
                class="dropdown-moi-qua-troi-moi w-dropdown-link">All Contracts</a></nav>
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
  <div class="w-container">
    <h1 class="heading-13">Contract details</h1>
    <div class="div-block-30">
      <div class="div-block-31">
        <h3 class="heading-10"><%= project.getProjectName()%></h3>
        <div class="text-block-34">Posted <%= project.getCreatedDate()%></div>
        <div class="text-block-34"><%= project.getLocation()%></div>
        <div class="div-block-34">
          <div class="div-block-35">
            <div class="div-block-39">
              <div class="text-block-38"><strong class="bold-text-3"><%= project.getHoursPerWeek()%> hours/week</strong></div>
            </div>
            <div class="div-block-39">Hourly</div>
          </div>
          <div class="div-block-35">
            <div class="div-block-39"><strong class="bold-text-3"><%= project.getDurationText()%></strong></div>
            <div class="div-block-39">Project Length</div>
          </div>
          <div class="div-block-37">
            <div class="div-block-39"><strong><%= project.getComplexity()%></strong></div>
            <div class="div-block-39">Understanding</div>
          </div>
          <div class="div-block-35">
            <div class="div-block-39"><strong class="bold-text-3"><%= project.getPaymentAmount()%>$</strong></div>
            <div class="div-block-39">Buget</div>
          </div>
        </div>
        <div class="div-block-42">
          <p class="paragraph-2"><%= project.getDescription()%></p>
        </div>
        <h4 class="heading-11">Skill and Expertise</h4>
        <div class="div-block-40">
          <div class="list-skill-copy">
            
              <%
                                    for (String skill : project.getSkillneed()) {
                                %>
                                <div class="skill-wrapper">
                                <div class="text-block-26" style="display: inline-block"><%= skill%></div>
                                </div>
                                <div style="width: 10px">
                                        </div>
                                <%
                                    }
                                %>
            
          </div>
        </div>
      </div>
            <%
                                    HirerDAO hirerDao = new HirerDAO();
                                    int jobPosted = hirerDao.getJobPosted(project.getHirerID());
                                    UserDAO userDao = new UserDAO();
                                    UserDTO hirer = userDao.getUserByID(project.getHirerID());
                                    
                                %>
      <div class="div-block-32">
        <div class="div-block-41">
          <h4 class="heading-12">About the Client</h4>
          <div class="text-block-39"><strong>Company: <%= project.getHirer()%></strong></div>
          <div class="text-block-39-copy"><%= project.getLocation()%></div>
          <div class="text-block-39"><strong><%=jobPosted%> jobs posted</strong></div>
          <div class="text-block-39-copy">The total number of Job Posted</div>
          <div class="text-block-39">Member since <%= hirer.getRegistrationDate()%></div>
        </div>
        <div class="div-block-33"><a data-w-id="539400ac-4bbd-5666-ff38-70ea48d7c087" href="#"
            class="button w-button">Feedback</a></div>
      </div>
    </div>
  </div>
        <%
                                LocalDate endDate = (LocalDate)request.getAttribute("END_DATE");
                                boolean checkAlreadlyFeedback =(boolean) request.getAttribute("CHECK_FEEDBACK_ALREADY");
                                String error = (String)request.getAttribute("ERROR_MESSAGE");
                                if(error == null) error ="";
                                LocalDate curent = LocalDate.now();                                
                            if(curent.isBefore(endDate.plusDays(7)) && curent.isAfter(endDate.minusDays(1)) && !checkAlreadlyFeedback){
                                %>
  <div style="display:none;opacity:0" class="div-block-44">
    <div class="div-block-45">
      <div class="form-block w-form">
        <h3>Feedback</h3>
        <form action="MainController" id="email-form-3" name="email-form-3" data-name="Email Form 3" method="get"><label
            for="name-3">Grade</label><input type="number" class="text-field-2 w-input" maxlength="256" name="clientGrade"
            data-name="Name 3" placeholder="1 to 5" id="name-3" required="" /><label for="field">Comment</label><input
            type="text" class="text-field-3 w-input" maxlength="256" name="seekerComment" data-name="Field"
            placeholder="Example Text" id="field" required="" />
            <input type="hidden" name ="proposalID" value="<%=proposal.getProposalID()%>"/>
            <input type="submit" name="action" value="FeedbackOfSeeker"
            data-wait="Please wait..." class="submit-button-3 w-button" /><a
            data-w-id="bc2479e9-b03c-215c-b509-b1e0cb9882a2" href="#" class="button-5 w-button">Cancel</a></form>
        <div class="w-form-done">
          <div>Thank you! Your submission has been received!</div>
        </div>
        <div class="w-form-fail">
          <div>Oops! Something went wrong while submitting the form.</div>
        </div>
      </div>
    </div>
  </div>
           <%
                            }
                            %>
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62d7f76293a2ee4589d1e5b0"
    type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
    crossorigin="anonymous"></script>
  <script src="https://uploads-ssl.webflow.com/62d7f76293a2ee4589d1e5b0/js/webflow.a6a2b17a0.js"
    type="text/javascript"></script>
  <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
<%
    }
%>
</html>