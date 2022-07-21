
<%@page import="sample.seeker.SeekerDTO"%>
<%@page import="sample.hirer.HirerDTO"%>
<!--http://fantacydesigns.com/-->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="dist/css/styleForVerify.css" />
        
        <title>Verify Account</title>
    </head>
    <body>
        <%
        HirerDTO hirer= (HirerDTO) session.getAttribute("authcode");
        if(hirer != null){
            %>
            <div class="container">
            <h2>Verify Your Account</h2>
            <p>We emailed you the six digit code to <%= hirer.getEmail() %> <br/> Enter the code below to confirm your email address.</p>
            <div class="code-container">
                <form action="VerifyCodeForHirer" method="post">
                    <input type="number" name="authcode1" class="code" placeholder="0" min="0" max="9" required pattern="[0-9]+">
                    <input type="number" name="authcode2" class="code" placeholder="0" min="0" max="9" required>
                    <input type="number" name="authcode3" class="code" placeholder="0" min="0" max="9" required>
                    <input type="number" name="authcode4" class="code" placeholder="0" min="0" max="9" required>
                    <input type="number" name="authcode5" class="code" placeholder="0" min="0" max="9" required>
                    <input type="number" name="authcode6" class="code" placeholder="0" min="0" max="9" required>
                    
                        <input type="submit" style="background-color: white;
                               height: 40px;
                               width: 200px;
                               margin-top: 40px;
                               border-color: #777;
                               color: #777;
                               
                               box-shadow: none"  value="VERIFY">

                    
                </form>

            </div>
            
        </div>
        <%
        }else{
        SeekerDTO seeker= (SeekerDTO) session.getAttribute("authcodeSeeker");
            %>
            <div class="container">
            <h2>Verify Your Account</h2>
            <p>We emailed you the six digit code to <%= seeker.getEmail() %> <br/> Enter the code below to confirm your email address.</p>
            <div class="code-container">
                <form action="VerifyCodeForHirer" method="post">
                    <input type="number" name="authcode1" class="code" placeholder="0" min="0" max="9" required pattern="[0-9]+">
                    <input type="number" name="authcode2" class="code" placeholder="0" min="0" max="9" required>
                    <input type="number" name="authcode3" class="code" placeholder="0" min="0" max="9" required>
                    <input type="number" name="authcode4" class="code" placeholder="0" min="0" max="9" required>
                    <input type="number" name="authcode5" class="code" placeholder="0" min="0" max="9" required>
                    <input type="number" name="authcode6" class="code" placeholder="0" min="0" max="9" required>
                    
                        <input type="submit" style="background-color: white;
                               height: 40px;
                               width: 200px;
                               margin-top: 40px;
                               border-color: #777;
                               color: #777;
                               
                               box-shadow: none"  value="VERIFY">

                    
                </form>

            </div>
            
        </div>
        <%
        }
        %>
        
        
        <script src="dist/js/jsForVerify.js"></script>
    </body>
</html>