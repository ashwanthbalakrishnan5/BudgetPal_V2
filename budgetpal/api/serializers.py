from rest_framework.serializers import ModelSerializer
from .models import User, expense


class UserSerializer(ModelSerializer):
    class Meta:
        model = User
        fields = "__all__"


class expenseSerializer(ModelSerializer):
    class Meta:
        model = expense
        fields = "__all__"
