<?php
  session_start();
  
  // connect to the database
  $db = mysqli_connect("localhost", "root", "", "markers");
  
  $name = $_GET['name'];
  $address = $_GET['address'];
  $lat = $_GET['lat'];
  $lng = $_GET['lng'];
  $type = $_GET['type'];

  $connection=mysql_connect ("localhost", "root", "");
if (!$connection) {
 die('Not connected : ' . mysql_error());
}

$db_selected = mysql_select_db($markers, $connection);
if (!$db_selected) {
 die ('Can\'t use db : ' . mysql_error());
}

$query = sprintf("INSERT INTO markers " .
        " (id, name, address, lat, lng, type ) " .
        " VALUES (NULL, '%s', '%s', '%s', '%s', '%s');",
        mysql_real_escape_string($name),
        mysql_real_escape_string($address),
        mysql_real_escape_string($lat),
        mysql_real_escape_string($lng),
        mysql_real_escape_string($type));

$result = mysql_query($query);

if (!$result) {
 die('Invalid query: ' . mysql_error());
}
  
?>