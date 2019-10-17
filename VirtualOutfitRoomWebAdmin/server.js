//Install express server
const express = require('express');
const path = require('path');

const app = express();


app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "YOUR-DOMAIN.TLD"); // update to match the domain you will make the request from
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
  });
  

// Serve only the static files form the dist directory
app.use(express.static(__dirname + '/dist/officelinkFront'));

app.get('/*', function(req,res) {

res.sendFile(path.join(__dirname+'/dist/officelinkFront/index.html'));
});

//Listen at port
app.listen(process.env.PORT || 3000);
