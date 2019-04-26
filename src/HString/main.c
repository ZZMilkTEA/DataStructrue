#define  _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include "HString.h"

int main() {
	//声明变量
	HString *testStr,*testChildStr;
	testStr = malloc(sizeof(HString));
	testChildStr = malloc(sizeof(HString));
	char *str1 = malloc(sizeof(char)*40), *str2 = malloc(sizeof(char) * 20);
	int pos,indexPos,index_KMP_pos;
	//输入需要的内容
	printf("请输入主串,不超过40字符:");
	scanf_s("%s", str1, 40);
	printf("请输入主串,不超过20字符:");
	scanf_s("%s", str2, 20);
	printf("请输入在主串匹配的起始位置，不超过主串长度：");
	scanf("%d", &pos);
	//初始化队串
	strCreate(testStr);
	strCreate(testChildStr);
	//给堆串赋值
	strAssign(testStr, str1);
	strAssign(testChildStr, str2);
	//输出串
	printf("---------------\n主串：");
	strOutput(testStr);
	printf("\n模式串:");
	strOutput(testChildStr);
	//输出简单匹配模式的结果
	indexPos = index(testStr, testChildStr, pos);
	if (indexPos) {
		printf("\n简单匹配模式位置：%d", indexPos);
	}
	else
	{
		printf("\n简单匹配模式未匹配");
	}
	//输出KMP匹配模式的结果
	index_KMP_pos = index_KMP(testStr, testChildStr, pos);
	if (indexPos) {
		printf("\nKMP匹配模式位置：%d\n",index_KMP_pos);
	}
	else
	{
		printf("\nKMP匹配模式未匹配\n");
	}
	//销毁串
	strDestory(testStr);
	strDestory(testChildStr);
	system("pause");
}