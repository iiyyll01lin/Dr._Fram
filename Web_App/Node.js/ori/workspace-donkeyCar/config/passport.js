/* login 相關 */
const LocalStrategy = require('passport-local').Strategy;
// 確認email跟password是否符合
const mongoose = require('mongoose');
// 確認password符合
const bcrypt = require('bcryptjs');

// Load User model
const User = require('../models/User');

module.exports = function (passport) {
    passport.use(
        new LocalStrategy(
            { usernameField: 'email' },
            (email, password, done) => {
                // 確認有沒有符合email的使用者
                User.findOne({ email: email })
                    .then(user => {
                        if (!user) {
                            return done(null, false, { message: '這個email還未註冊' });
                        }

                        // 確認密碼有無符合
                        bcrypt.compare(password, user.password, (err, isMatch) => {
                            if (err) throw err;

                            if (isMatch) {
                                return done(null, user);
                            } else {
                                return done(null, false, { message: '密碼錯誤' });
                            }
                        }); // user.password來自資料庫
                    })
                    .catch(err => console.log(err));
            })
    );
    //使用者的 ID 序列化後存到 session，當後續 requests 時，透過 ID 來找到使用者，並存在 req.user中
    passport.serializeUser((user, done) => {
        done(null, user.id);
    });

    passport.deserializeUser((id, done) => {
        User.findById(id, (err, user) => {
            done(err, user);
        });
    });
}