# setup uri
$endpoint = 'http://localhost:8080'
$uri = "${endpoint}/oauth/token"

# client credentials
$client = "crmClient1"
$clientSecret = "crmSuperSecret"

# user credentials
$user = "sanjeev"
$password = "Admin"

# Headers and body setup
$contentType = 'application/json'
$body = @{username = $user; password = $password; grant_type = 'password'}

$pair = "$($client):$($clientSecret)"

$encodedCreds = [System.Convert]::ToBase64String([System.Text.Encoding]::ASCII.GetBytes($pair))

$basicAuthValue = "Basic $encodedCreds"

$Headers = @{
    'Authorization' = $basicAuthValue
}

# invoke /oauth/token
$authresponse = Invoke-RestMethod -Method OPTIONS -Uri "$($uri)" -Headers $Headers -Body $body



# get values
$uri = "${endpoint}/api/cv/"
$token = $authresponse.access_token
$auth = "Bearer $token"
$Headers = @{
    Authorization = $auth
}
$response = Invoke-RestMethod -Method Get -Uri "$($uri)" -Headers $Headers

echo $response.Count
