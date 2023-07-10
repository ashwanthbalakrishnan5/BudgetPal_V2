from django.db import models


# Create your models here.
class User(models.Model):
    username = models.CharField(max_length=100)
    password = models.CharField(max_length=100)


class expense(models.Model):
    username = models.ForeignKey(User, on_delete=models.CASCADE)
    catagory = models.CharField(max_length=100, default="other")
    amount = models.PositiveIntegerField()
    date = models.DateField(auto_now_add=True)
