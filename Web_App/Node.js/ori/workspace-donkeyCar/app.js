const express = require('express');
const app = express();
// flash是配合session使用的，所以在使用flash之前，
// 要引入express-session模塊，它往往用在登錄和註冊，
// 消息只會通知一次就消失了，
// 其中redirect和flash是不能分開使用的。
const flash = require('connect-flash');
const session = require('express-session');
const passport = require('passport');
const expressLayouts = require('express-ejs-layouts');

// 靜態文件
var path = require('path');
app.use(express.static(path.join(__dirname, 'public')));
// Passport Config
require('./config/passport')(passport);

// EJS View
app.use(expressLayouts);
//app.set('views', path.join(__dirname, 'views'));
app.set('view engine','ejs');

// BodyParser
app.use(express.urlencoded({ extended: true })); // 可放文字 聲音 影像

// Express Session (原本有cookie 這裡不需要)
app.use(
    session({
      secret: 'secret',
      resave: true,
      saveUninitialized: true
    })
);

// Passport中介軟體
app.use(passport.initialize());
app.use(passport.session());

// Connect flash
app.use(flash());

// 全域變數
app.use((req,res,next) => {
    res.locals.success_msg =  req.flash('success_msg');
    res.locals.error_msg = req.flash('error_msg');
    res.locals.error = req.flash('error');
    next();
});

// router 路由
app.use('/',require('./routes/index'));
app.use('/users',require('./routes/users'));

// mongoose
const mongoose=require('mongoose');
// DB Config
const db = require('./config/keys').MongoURI;

// Connect to Mongo
mongoose.connect(db,{ useNewUrlParser:true })
.then(()=>console.log('MongoDB 已連上...'))
.catch(err => console.log(err));

// 在哪一個port
const PORT=process.env.PORT || 5000; // process.env使用者環境資訊的物件
app.listen(PORT, console.log('Server started on port : '+PORT));