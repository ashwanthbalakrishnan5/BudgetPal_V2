from django.shortcuts import render
from rest_framework.viewsets import ModelViewSet
from .models import User, expense
from .serializers import UserSerializer, expenseSerializer

# Create your views here.


class UserViewSet(ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserSerializer


class expenseViewSet(ModelViewSet):
    queryset = expense.objects.all()
    serializer_class = expenseSerializer
