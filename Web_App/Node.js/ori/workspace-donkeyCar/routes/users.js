const express = require('express');
const router = express.Router();
const bcrypt = require('bcryptjs');
//登入處理 變數
const passport = require('passport');

// Load User model
const User = require('../models/User');

//Login Page
router.get('/login', (req, res) => res.render('login'));

//Register Page
router.get('/register', (req, res) => res.render('register'));

//Register Handle
router.post('/register', (req, res) => {
    const { name, email, password, password2 } = req.body;
    let errors = [];

    // 檢查需求欄位
    if (!name || !email || !password || !password2) {
        errors.push({ msg: '所有欄位都需要輸入值' });
    }
    //檢查密碼符合
    if (password != password2) {
        errors.push({ msg: '輸入之兩個密碼不相符' });
    }
    //檢查密碼長度
    if (password.length < 6) {
        errors.push({ msg: '密碼至少六位' });
    }

    if (errors.length > 0) { // 如果有錯誤的話
        res.render('register', {
            errors,
            name,
            email,
            password,
            password2
        });
    } else {
        //Validation Passed
        User.findOne({ email: email })
            .then(user => {
                if (user) {
                    // User Exists
                    errors.push({
                        msg: 'Email已經存在'
                    });
                    res.render('register', {
                        errors,
                        name,
                        email,
                        password,
                        password2
                    });
                } else {
                    // New User(
                    const newUser = new User({
                        name,
                        email,
                        password
                    });
                    //console.log(newUser);
                    //res.send('Hello');

                    //Hash Password 加密密碼
                    bcrypt.genSalt(
                        10,
                        (err, salt) => bcrypt.hash(
                            newUser.password,
                            salt,
                            (err, hash) => {
                                if (err) throw err;
                                // Set password to Hashed
                                newUser.password = hash;
                                // Save User
                                newUser.save()
                                    .then(user => {
                                        req.flash('success_msg', '註冊成功，請登入');
                                        res.redirect('/users/login');
                                    })
                                    .catch(err => console.log(err));
                            }
                        )
                    );
                }
            });
        //res.send('Pass');
    }
    //console.log(req.body);
    //res.send('Hello!!!');

});
// 登入處理(路由)
// Login
router.post('/login', (req, res, next) => {
    passport.authenticate('local', {
        successRedirect: '/dashboard',
        failureRedirect: '/users/login',
        failureFlash: true
    })(req, res, next);
});
// 登出處理(路由)
// Logout
router.get('/logout', (req, res) => {
    req.logout();
    req.flash('success_msg', '你已成功登出'); // 送出成功訊息
    res.redirect('/users/login');
  });

module.exports = router;