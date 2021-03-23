// mongoose
const mongoose = require('mongoose');

// 建立schema
const UserSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true
    },
    email: {
        type: String,
        required: true
    },
    password: {
        type: String,
        required: true
    },
    date: {
        type: Date,
        default: Date.now
    }
});

// 丟出來
const User = mongoose.model('User', UserSchema);

module.exports = User;