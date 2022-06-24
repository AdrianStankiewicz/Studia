<?php

if($_SERVER['REQUEST_METHOD']=="POST") $t=$_POST;
if($_SERVER['REQUEST_METHOD']=="GET") $t=$_GET;

if(count($t)>0)
{
	$s='<p>Odebrano formularz - liczba elementów = '.count($t).'</p>';

	$s.='<h2>Ustawienia</h2>';

	$s.='<p>Metoda wysłania: '.$_SERVER['REQUEST_METHOD'].'</p>';

	$s.='<p>Czas wysłania: '.date("d-m-Y H:i",$_SERVER['REQUEST_TIME']).'</p>';

	$s.='<h2>Dane</h2>';

	foreach($t as $k => $v)
	{
		if(is_array($v))
		{ 
			$s.='<p>Array ['.$k.']: { ';
			foreach($v as $ki => $vi) $s.='['.$ki.'] => '.$vi."; ";
			$s.='}</p>';
		}	
		else $s.='<p>['.$k.'] => '.$v.'</p>';
	}

	echo $s;
}
else echo '<p class="uwaga">Uwaga: Skrypt działa tylko po wysłaniu formularza.</p>';	

?>