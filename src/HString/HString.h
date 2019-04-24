#include <stdio.h>
#include <stdlib.h>

typedef struct
{
	char* ch;
	int len;	//串长度
}HString;

//串的创建
void strCreate(HString *s) {
	s->ch = NULL;
	s->ch = NULL;
}

//串赋值
int strAssign(HString *s, char *tval) {
	if (s->ch != NULL) { 
		free(s->ch); 
	}
	int i = 0;  
	while (tval[i] != '\0') { 
		i++; 
	}
	int len = i;
	if (len) {
		s->ch = (char *)malloc(len);
		if (s->ch == NULL)  return 0;
		for (i = 0; i < len; i++)  s->ch[i] = tval[i];
	}
	else  s->ch = NULL;
	s->len = len;
	return 1;
}

//串插入
int strInsert(HString *s, int pos, HString *t) {
	if (pos<1 || pos>s->len + 1 || s->len == 0 || t->len == 0)
		return 0;
	char* temp = (char *)malloc(s->len + t->len);
	if (temp == NULL)  return(0);
	// 复制S前串，T串，S后串
	for (int i = 0; i < pos - 1; i++) {
		temp[i] = s->ch[i];
	}
	for (int i = 0; i < t->len; i++) {
		temp[i + pos - 1] = t->ch[i];
	}
	for (int i = pos - 1; i < s->len; i++) {
		temp[i + t->len] = s->ch[i];
	}
		free(s->ch);
		s->ch = temp;
		s->len += t->len;
	return 1;
}

//串的简单模式匹配
int index(HString *s, HString *t, int pos) {
	int i = pos - 1;
	int j = 0;
	while (i < s->len&&j < t->len)
	{
		if (s->ch[i] == t->ch[j]) {
			i++; j++; 
		}
		else {
			i = i - j + 1; j = 0;
		}
	}
	if (j == t->len) { 
		return i - t->len + 1;
	}
	else  return 0;
}

//next[j]的计算
void get_next(HString *t, int* next) {
	next[0] = -1;
	int j = -1;
	int i = 0;
	while (i < t->len) {
		if (j == -1 || t->ch[i] == t->ch[j])
		{
			++i; ++j; next[i] = j;
		}
		else
			j = next[j];
	}

}

//串的KMP模式匹配
int Index_KMP(HString *s, HString *t, int pos) {
	int i = pos - 1;  
	int j = 0;
	int *next;
	next = malloc(sizeof(int) * t->len);
	get_next(t, next);
	while (i < s->len&&j < t->len) {
		if (s->ch[i] == t->ch[j] || j == -1) {
			++i;
			++j; 
		}
		else {
			j = next[j];
		}
	}
	if (j == t->len) {
		return i - t->len + 1;
	}
	else {
		return 0;
	}
}



//串输出
void strOutput(HString *s) {
	for (int i = 0; i < s->len; i++) {
		printf("%c", s->ch[i]);
	}
}


