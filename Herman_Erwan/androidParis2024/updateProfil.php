<?php
	require_once("modele.class.php"); 
	$unModele = new Modele("localhost", "androidparis2024", "root", ""); 

	if (isset ($_REQUEST["email"]) and isset ($_REQUEST["iduser"]) ){
		$where = array("iduser"=>$_REQUEST["iduser"]); 

		$donnees = array("nom"=>$_REQUEST['nom'], 
				"prenom"=>$_REQUEST['prenom'],
				"email"=>$_REQUEST['email'],
				"mdp"=>$_REQUEST['mdp'], 
				"tel"=>$_REQUEST['tel']
					);

		$unModele->setTable ("user");
		$unUser = $unModele->update($donnees, $where); 
		print ("[{'ok':'1'}]") ;
		
	}else {
		print("[]"); 
	}	 
?>







