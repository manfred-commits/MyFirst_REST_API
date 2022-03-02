package com.manfredipiraino.rest;

import javax.ws.rs.FormParam;

/** REST - Representational state transfer 
Web Service, espone un insieme di risorse disponibili per i client
Si basano esclusivamente sullo scambio di messaggi tramite protocollo HTTP (GET, POST, PUT, DELETE, ecc.)
Il contenuto dei messaggi è solitamente JSON o XML
Approccio “leggero”
*/
/** L'architettura REST si basa su HTTP. Il funzionamento prevede una struttura degli URL ben definita 
che identifica univocamente una risorsa o un insieme di risorse e l'utilizzo dei metodi HTTP specifici 
per il recupero di informazioni (GET), per la modifica (POST, PUT, PATCH, DELETE) ecc.
*/
/** JAX-RS
Fornisce supporto nella creazione di Web Service secondo il modello di architettura REST. 
Utilizza le annotazioni per semplificare lo sviluppo e la distribuzione di client di servizi Web ed endpoint.
Esistono due principali implementazioni dell'API JAX-RS:
- Jersey: è l'implementazione di riferimento fornita da Sun. Basta configurare il suo servlet in web.xml 
e aggiungere le dipendenze richieste. 
- RESTEasy: l'implementazione fornita dal progetto JBoss
*/

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;

// Definisce il path della risorsa
@Path("myresource")
public class MyResource {

	// ArrayList
	private static ArrayList<MyUser> myUsers = new ArrayList<>();

	// Il verbo HTTP al quale risponde la risorsa
	@GET
	@Path("/myGET_myJSON")
	// Il tipo Mediatype che la risorsa può produrre
	@Produces(MediaType.APPLICATION_JSON)
	public Response myJSON() {
		String myJson = "{\"nome\":\"Aldo\", \"cognome\":\"Rossi\", \"eta\":\"22\"}";
		return Response.status(200).entity(myJson).build();
	}

	// POST con ricezione di oggetto JSON
	@POST
	@Path("/myPOST_myUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response myUser(MyUser myUser) {
		myUsers.add(myUser);
		String myJson = "{\"result\":\"Ok! Utente aggiunto\"}";
		return Response.status(200).entity(myJson).build();
	}

	// GET con response di List oggetti JSON
	@GET
	@Path("/myGET_myUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response myUsers() {
		return Response.status(200).entity(myUsers).build();
	}

	// GET con ricezione di Parametri da Querystring
	@GET
	@Path("/myGET_myQueryString")
	@Produces(MediaType.APPLICATION_JSON)
	public Response myQueyString(@QueryParam("myUserName") String myUserName, @QueryParam("myUserId") String myUserId) {
		String myUN = myUserName;
		String myUI = myUserId;
		return Response.status(200).entity(myUN + " " + myUI).build();
	}

	// GET con ricezione di Parametri da Path
	@GET
	@Path("/myGET_myParams/{myUserName}/{myUserId}")
	public Response getUserHistory(@PathParam("myUserName") String myUserName, @PathParam("myUserId") String myUserId) {
		String myUN = myUserName;
		String myUI = myUserId;
		return Response.status(200).entity(myUN + " " + myUI).build();

	}

	// POST con ricezione di Parametri da Form
	@POST
	@Path("/myPOST_myForm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response myForm(@FormParam("p1") String myUserName, @FormParam("p2") String myUserPassword,@FormParam("p3") int myUserAge) {
		String myUN = myUserName;
		String myUP = myUserPassword;
		int myUA = myUserAge;
		MyUser myUser= new MyUser(myUserName,myUserPassword,myUserAge);
		myUsers.add(myUser);
		// String myJson = "{\"result\":"+myUN+"}";
		return Response.status(200).entity("Ok: utente aggiunto! "+myUN + " " + myUP+" " + myUA).build();
	}

}
