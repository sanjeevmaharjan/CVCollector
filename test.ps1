$cliet = "crmClient1"
$clientSecret = "crmSuperSecret"

$user = "sanjeev"
$password = "Admin"

# http basic authorization header for token request
$basic = @{ "Authorization" = ("Basic", [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes(($client, $clientSecret -join ":"))) -join " ") }

# post username and password body

iwr 