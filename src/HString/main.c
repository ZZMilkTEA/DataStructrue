#define  _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include "HString.h"

int main() {
	//��������
	HString *testStr,*testChildStr;
	testStr = malloc(sizeof(HString));
	testChildStr = malloc(sizeof(HString));
	char *str1 = malloc(sizeof(char)*40), *str2 = malloc(sizeof(char) * 20);
	int pos,indexPos,index_KMP_pos;
	//������Ҫ������
	printf("����������,������40�ַ�:");
	scanf_s("%s", str1, 40);
	printf("����������,������20�ַ�:");
	scanf_s("%s", str2, 20);
	printf("������������ƥ�����ʼλ�ã��������������ȣ�");
	scanf("%d", &pos);
	//��ʼ���Ӵ�
	strCreate(testStr);
	strCreate(testChildStr);
	//���Ѵ���ֵ
	strAssign(testStr, str1);
	strAssign(testChildStr, str2);
	//�����
	printf("---------------\n������");
	strOutput(testStr);
	printf("\nģʽ��:");
	strOutput(testChildStr);
	//�����ƥ��ģʽ�Ľ��
	indexPos = index(testStr, testChildStr, pos);
	if (indexPos) {
		printf("\n��ƥ��ģʽλ�ã�%d", indexPos);
	}
	else
	{
		printf("\n��ƥ��ģʽδƥ��");
	}
	//���KMPƥ��ģʽ�Ľ��
	index_KMP_pos = index_KMP(testStr, testChildStr, pos);
	if (indexPos) {
		printf("\nKMPƥ��ģʽλ�ã�%d\n",index_KMP_pos);
	}
	else
	{
		printf("\nKMPƥ��ģʽδƥ��\n");
	}
	//���ٴ�
	strDestory(testStr);
	strDestory(testChildStr);
	system("pause");
}