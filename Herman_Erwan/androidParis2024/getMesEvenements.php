<?php
	require_once("modele.class.php"); 
	$unModele = new Modele("localhost", "androidparis2024", "root", "");  

	if (isset($_REQUEST['email']))
	{
		$unModele->setTable("mesEvenements"); 
		$lesEvenements = $unModele->selectAll("*"); 
		$tab = array();
		foreach ($lesEvenements as $unEvent) {
			if($_REQUEST['email']==$unEvent['email'])
			{
				$ligne = array("idevenement"=>$unEvent['idevenement'],
					"designation"=>$unEvent['designation'], 
					"dateevent"=>$unEvent['dateEvent'], 
					"heureevent"=>$unEvent['heureEvent'], 
					"lieu"=>$unEvent['lieu'], 
					"nbplaces"=>$unEvent['nbPlaces'], 
					"prix"=>$unEvent['prix']);
					$tab[] = $ligne;
			} 
		}
		print(json_encode($tab));
	}else {
		print("[]");
	}
?>