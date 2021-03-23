let express = require('express');
let app = express();
let router = express.Router();
let exec = require('child_process').exec;
let port = 5000;
app.use(express.static(__dirname + '/public'));
/*
app.get('/', function (req, res) {
    res.sendFile(__dirname+'/public/index.html');  //回應靜態文件
});
*/
router.get('/activate', function (req, res, next) {
    //執行 ls -al 指令
   /* exec('cd ~/mycar ', function (err, stdout, stderr) {
        console.log('cd mycar!!');});
*/

    exec('python3 yolo-object-detection.py -y ~/darknet-master/mango_data/', function (err, stdout, stderr) {
        
        console.log('activate yolo-object-detection');
        console.log("[stdout]"+stdout);
        console.log("[stderr]"+stderr);
        
       
    });
    res.sendFile(__dirname+'/public/active.html');
});

router.get('/stop', function (req, res, next) {
    //執行 ls -al 指令
   /* exec('cd ~/mycar ', function (err, stdout, stderr) {
        console.log('cd mycar!!');});
*/

    exec('q', function (err, stdout, stderr) {
        
        console.log('q');
        console.log("[stdout]"+stdout);
        console.log("[stderr]"+stderr);
        
       
    });
    res.sendFile(__dirname+'/public/stop.html');
});


app.use('/', router);
var server = app.listen(5000, function () {
    console.log('Node server is running..');
});
