from FlaskWebProject1 import db
from werkzeug.security import generate_password_hash, check_password_hash

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nickname = db.Column(db.String(64), index=True, unique=True)
    passward= db.Column(db.String(64), index=True, unique=True)
    email = db.Column(db.String(120), index=True, unique=True)
    posts = db.relationship('Post', backref='author', lazy='dynamic')
    about_me = db.Column(db.String(140))
    last_seen = db.Column(db.DateTime)

    is_authenticated = True
    is_active = True
    is_anonymous = False

    def get_id(self):
            return str(self.id)  # python 3

    def __repr__(self):
        return '<User %r>' % (self.nickname)

    def set_password(self, password):
        self.passward = generate_password_hash(password)

    def check_password(self, password):
        return check_password_hash(self.passward, password)

    def avatar(self,size):
        return 'http://www.gravatar.com/avatar/f9879d71855b5ff21e4963273a886bfc?d=mm&s=' + str(size)

    @staticmethod
    def make_unique_nickname(nickname):
        if User.query.filter_by(nickname = nickname).first() == None:
         return nickname
        version = 2
        while True:
            new_nickname = nickname + str(version)
            if User.query.filter_by(nickname = new_nickname).first() == None:
                break
            version+=1
        return new_nickname


class Post(db.Model):
    id = db.Column(db.Integer, primary_key = True)
    body = db.Column(db.String(140))
    timestamp = db.Column(db.DateTime)
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'))

    def __repr__(self):
        return '<Post %r>' % (self.body)
