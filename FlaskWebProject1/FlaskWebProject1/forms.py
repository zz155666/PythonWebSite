from flask_wtf import Form
from wtforms import StringField, BooleanField,SubmitField,PasswordField
from wtforms.validators import ValidationError, DataRequired, Email, EqualTo
from FlaskWebProject1.models import User

class LoginForm(Form):
    nickname=StringField('nickname',validators=[DataRequired()])
    password=PasswordField('password',validators=[DataRequired()])
    remember_me=BooleanField('remember_me',default=False)
    submit = SubmitField('Sign In')

class RegistrationForm(Form):
    nickname = StringField('nickname', validators=[DataRequired()])
    email = StringField('email', validators=[DataRequired(), Email()])
    password = PasswordField('password', validators=[DataRequired()])
    password2 = PasswordField(
        'repeat password', validators=[DataRequired(), EqualTo('password')])
    submit = SubmitField('Register')

    def validate_nickname(self,nickname):
        user = User.query.filter_by(nickname=nickname.data).first()
        if user is not None:
            raise ValidationError('Please use a different nickname.')

    def validate_email(self, email):
        user = User.query.filter_by(email=email.data).first()
        if user is not None:
            raise ValidationError('Please use a different email address.')


