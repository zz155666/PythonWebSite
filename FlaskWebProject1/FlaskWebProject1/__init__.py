"""
The flask application package.
"""
import os
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_login import LoginManager
from flask_openid import OpenID
from config import basedir


app = Flask(__name__)
app.config.from_object('config')
db = SQLAlchemy(app)

lm = LoginManager()
lm.init_app(FlaskWebProject1)
oid = OpenID(FlaskWebProject1, os.path.join(basedir, 'tmp'))

from FlaskWebProject1 import views, models
