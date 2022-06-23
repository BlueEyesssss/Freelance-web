<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Review Payment</title>
        <style type="text/css">
            table{
                border: 0
            }
            table td{
                padding: 10px;
            }
        </style>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div align="center">
            <h1>Confirm Paying</h1>
            <form action="ExecutePaymentServlet" method="post">
                <table>
                    <tr>
                        <td>
                            <input type="hidden" name="paymentId" value="${param.paymentId}" />
                            <input type="hidden" name="PayerID" value="${param.PayerID}" />
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Pay Now" />
                        </td>
                    </tr>		
                </table>
            </form>
        </div>

    </body>
</html>
