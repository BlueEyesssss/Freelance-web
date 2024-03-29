/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.payment;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PaymentServices {
//    private static final String CLIENT_ID = "";
//    private static final String CLIENT_SECRET = "";
    private static final String MODE = "sandbox";
    
    public String authorizePayment(OrderDetail orderDetail, String client_id, String client_secret) throws PayPalRESTException{
        Payer payer = getPayerInformation();    
        RedirectUrls redirectUrls = getRedirectUrls();  
        List<Transaction> listTransaction = getTransactionInformation(orderDetail); 
        
        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction)
                      .setRedirectUrls(redirectUrls)
                      .setPayer(payer)
                      .setIntent("authorize");
        
        APIContext apiContext = new APIContext(client_id, client_secret, MODE);
        Payment approvedPayment =  requestPayment.create(apiContext);
        
        System.out.println(approvedPayment);
        
        return getApprovalLink(approvedPayment);
    }
    
    private String getApprovalLink(Payment approvedPayment){
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;
        
        for(Links link: links){
            if(link.getRel().equalsIgnoreCase("approval_url")){
                approvalLink = link.getHref();
            }
        }
        return approvalLink;
    }
    
    private List<Transaction> getTransactionInformation(OrderDetail orderDetail){   
        Details details = new Details();
        details.setShipping(orderDetail.getShipping());     
        details.setSubtotal(orderDetail.getSubtotal());     
        details.setTax(orderDetail.getTax());               
        
        Amount amount = new Amount();
        amount.setCurrency("USD");      
        amount.setTotal(orderDetail.getTotal());    
        amount.setDetails(details);     
        
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(orderDetail.getProductName());   
        
        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();
        
        Item item = new Item();
        item.setCurrency("USD")
            .setName(orderDetail.getProductName())
            .setPrice(orderDetail.getSubtotal())
            .setTax(orderDetail.getTax())
            .setQuantity("1");  
        
        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);
        
        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);
        
        return listTransaction;
    }
    
    private RedirectUrls getRedirectUrls(){             
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8081/Freelance/cancel.html");  //sửa port 8084 thành port 8080
        redirectUrls.setReturnUrl("http://localhost:8081/Freelance/ReviewPaymentServlet");   
        
        return redirectUrls;
    }
    
    public Payment getPaymentDetails(String paymentId, String client_id, String client_secret) throws PayPalRESTException{
        APIContext apiContext = new APIContext(client_id, client_secret, MODE);
        return Payment.get(apiContext, paymentId);
    }
    
    public Payment executePayment(String paymentId, String payerId, String client_id, String client_secret) throws PayPalRESTException{
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);
        
        Payment payment = new Payment().setId(paymentId);
        
        APIContext apiContext = new APIContext(client_id, client_secret, MODE);
        
        return payment.execute(apiContext, paymentExecution);
    }
    
    private Payer getPayerInformation(){
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        
        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("...")               
                 .setLastName("...")
                 .setEmail("example@gmail.com");      
        payer.setPayerInfo(payerInfo);
        return payer;
    }
}
