package com.example.email_generic;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public  class EmailGeneric {


 //****************************Message et subject Vendeur(Paiement par carte El-Dahabia******************************************************
 static String subject1 = "Prepare delivery for N° num_commande";
 static String VendeurDahaB = "Hello\n You have a new order for delivery with number num_commande \n" +
         "The delivery document is attached below.\n" +
         "To check the payment, please see this link " + "<a href=" + "https://edcarte.poste.dz/fr/bienvenue_adhesion.php" + ">BaridiMob</a>";
 //****************************Courriel Acheteur(Paiement par carte El-Dahabia(Option livraison domicile/point livraison/chez vendeur)******************************************************
 static String subject2 = "Confirm order N° num_commande";
 //---------------------------livraison à domicile---------------------------
 static String AcheteurDomicile = "Hello,\n" +
         "your purchase is confirmed with the following delivery information: \n" +
         "Option of delivery: Home delivery" +
         "\nWilaya:wilaya" +
         "\nCommon: commune" +
         "\nPostal code: code_postal" +
         "\nNumber and street,Avenue: num_rue" +
         "\nPhone: Téléphone" +
         "\nEmail: adr_mail" +
         "\nLink GPS:<a href=" + "link_GPS" + ">link_GPS</a>";
 //-----------point de livraison-------------------
 static String AcheteurPoint = "Hello,\n" +
         "your purchase is confirmed with the following delivery information: \n" +
         "Option of delivery: Delivery point" +
         "\nDelivery point: point_livraison" +
         "\nPhone: Téléphone" +
         "\nE-mail: adr_mail" +
         "\nLink GPS:<a href=" + "link_GPS" + ">link_GPS</a>";
 //-------------------Chez le vendeur-----------------------
 static String AcheteurChezVendeur = "Hello,\n" +
         "your purchase is confirmed with the following delivery information: \n" +
         "Option of delivery: Delivery point to the seller" +
         "\nDelivery point:point_livraison" +
         "\nPhone: Téléphone" +
         "\nE-mail: adr_mail" +
         "\nLink GPS:<a href=" + "link_GPS" + ">link_GPS</a>" +
         "\nDelivery time: Delai days" +
         "\nTransport costs: Frais_transport DA";
 //****************************Courriel Vendeur(Paiement par virement bancaire******************************************************
 //------------------------------------------------Réservation pour vendeur-------------------------------------------------//
 static String subject3 = "Reserved order N° num_commande";
 static String VendeurVirementReserv = "Hello,\n" + "You have a new order with order N° num_commande \n" +
         "To check the payment, please see this link " + "<a href=" + "https://edcarte.poste.dz/fr/bienvenue_adhesion.php" + ">BaridiMob</a>\n" +
         "The order form is attached bellow.\n" +
         "<button style=" + "width: 200px;height: 50px;background:#5cbf2a;text-align: center;border-radius: 28px;border-color: #5cbf2a;border-width: 0px" + "><a  href=" + "lien_confirm" + " style=" + "color: white;text-decoration-line: none; font-weight: bold;font-size: medium;" + ">Confirm the order</a></button>" +
         "<button style=" + "width: 200px;height: 50px;background:#6c7c7c;text-align: center;border-radius: 28px;border-color: #6c7c7c;border-width: 0px" + "><a  href=" + " lien_cancel " + " style=" + "color: white;text-decoration-line: none; font-weight: bold;font-size: medium;" + ">Refuse the order</a></button>";
 //------------------------------------------------Réservation pour acheteur-------------------------------------------------//

 static String subject4 = "Reservation deadline N° num_commande";
 static String AcheteurVirRes = "Hello,\n" + "Your reservation request expires after: Delai days, and if the seller rejects the reservation, or if the reservation deadline has passed without confirmation from the seller, your reservation will be automatically canceled.";
 //------------------------------------------------Réservation confirmer par vendeur -------------------------------------------------//
 static String subject5 = "Reservation acceptance N° num_commande";
 static String AcheteurVirConfirmReserv = "Hello,\n" +
         "Your reservation has been accepted by the seller, you have \"Delai\" days to pay to the bank account No. \"num_commande\"\n" +
         "To complete the payment process" +
         "<a href=" + "lien_confirm" + ">Click here</a>";
 //------------------------------------------------Réservation refuser -------------------------------------------------//
 static String subject6 = "Cancelation of réservation N° num_commande";
 static String AcheteurVirRefuReserv = "Hello,\n" + "With all my regrets, your reservation is canceled.";
 //------------------------------------------Délai expiré(Annulation de commande) --------------------------------------------//
 //Vendeur
 //subject6
 static String VendeurRevCancel = "Hello,\n" +
         "Order number num_commande has been cancelled.";
 //Acheteur
 //subject6
 static String AcheteurVirDelaiExpir = "Hello,\n" +
         "Your order N° num_commande has been canceled because you did not complete the payment in the specified period.";
 //------------------------------------------------Paiement commande pour vendeur-------------------------------------------------//
 //------------------------------------------Au Délai(Paiment effectué)--------------------------------------------//
 static String subject7 = "Confirm payment for order N° num_commande";
 static String VendeurVirPay = "Hello,\n" + "Payment has been made for order number num_commande, payment and delivery receipt attached below." +
         "To check the payment, please see this link " + "<a href=" + "lien_banque" + ">Check</a>\n" +
         "<button style=" + "width: 200px;height: 50px;background:#5cbf2a;text-align: center;border-radius: 28px;border-color: #5cbf2a;border-width: 0px" + "><a  href=" + "lien_confirm" + " style=" + "color: white;text-decoration-line: none; font-weight: bold;font-size: medium;" + ">Confirm delivery</a></button>" +
         "<button style=" + "width: 200px;height: 50px;background:#6c7c7c;text-align: center;border-radius: 28px;border-color: #6c7c7c;border-width: 0px" + "><a  href=" + " lien_cancel " + " style=" + "color: white;text-decoration-line: none; font-weight: bold;font-size: medium;" + ">Refuse delivery</a></button>";
 //------------------------------------------------Paiement commande pour Acheteur-------------------------------------------------//
 //------------------------------------------(envoyer recu au délai) et Acheteur Attent reponse de la validation reçu par vendeur--------------------------------------------//
 static String subject8 = "Waiting for payment confirmation (N° num_commande)";
 static String AcheteurVirPay = "Hello,\n" + "Your purchase with num_commande is waiting for the seller to verify the validity of the payment receipt.\n" +
         "The answer will be sent within Delai days";
 //------------------------------------------------Reçu non valid pour Acheteur(Avec nouveau delai et nouveau recu)-------------------------------------------------//
 static String subject9 = "Invalid payment receipt (N° num_commande)";
 static String AcheteurNValidRecu = "Hello,\n" +
         "Your receipt is incorrect for order number N° num_commande, please send a valid receipt\n" +
         "Beware, you only have a second attempt to submit a valid payment receipt or your order will be cancelled.\n" +
         "<button style=" + "width: 200px;height: 50px;background:#5cbf2a;text-align: center;border-radius: 28px;border-color: #5cbf2a;border-width: 0px" + "><a  href=" + "lien_confirm" + " style=" + "color: white;text-decoration-line: none; font-weight: bold;font-size: medium;" + ">Pay</a></button>";

 //------------------------------------------------Reçu valid et paiement effectue msg pour ITInfinity-------------------------------------------------//
 // subject=sbject2
 static String ITInfinityMsg = "Hello,\n" + "The request payment reseved with order N°" + "num_commande " + "is confirmed.";
 //------------------------------------------------Pour Acheteur(Echec de transaction)-------------------------------------------------//
 static String subject10 = "Failed transaction";
 static String AcheteurechecTransaction = "Hello,\n" + "You have a failure in your payment transaction, please retry.";


 public static Mail email(String from, String to, String subject, String text, String num_commande, List<String> files, String willaya, String commune, String code_postal, String num_rue, String Téléphone, String mail, String link_GPS, String point_livraison, String Delai, String Frais_transport, String lien_confirm, String lien_cancel, String num_compte, String lien_banque) throws IOException {

  Email From = new Email(from);
  Email To = new Email(to);
  Content content;
  content = new Content("text/html", text.replaceFirst(
          "num_commande", num_commande).replaceFirst(
          "wilaya", willaya).replaceFirst(
          "commune", commune).replaceFirst(
          "code_postal", code_postal).replaceFirst(
          "num_rue", num_rue).replaceFirst(
          "Téléphone", Téléphone).replaceFirst(
          "adr_mail", mail).replaceFirst(
          "link_GPS", link_GPS).replaceFirst(
          "point_livraison", point_livraison).replaceFirst(
          "Delai", Delai).replaceFirst("Frais_transport", Frais_transport).replaceFirst(
          "lien_confirm", lien_confirm).replaceFirst(
          "lien_cancel", lien_cancel).replaceFirst(
          "num_compte", num_compte));
  Mail message = new Mail(From,subject.replaceFirst("num_commande", num_commande),To,content);
  List<Attachments> attachement = new ArrayList<>();
  Attachments atch;
  for (String file : files) {
   atch = new Attachments();
   File filepath = new File(file);
   byte[] fileContent = Files.readAllBytes((filepath.toPath()));
   String encodedString = Base64.getEncoder().encodeToString(fileContent);
   atch.setContent(encodedString);
   atch.setFilename(filepath.getName());
   attachement.add(atch);
  }
  for (Attachments attch:attachement){
   message.addAttachments(attch);
  }
  return message;
 }

}