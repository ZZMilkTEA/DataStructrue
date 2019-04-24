#include <stdio.h>
#include <stdlib.h>
#include "HString.h"

int main() {
	HString testStr, testChildStr;
	HString *p = &testStr, *pChild = &testChildStr;
	strCreate(p);
	strCreate(pChild);
	strAssign(p, "abaaba");
	strAssign(pChild, "aa");
	strOutput(p);
	printf("\n");
	strOutput(pChild);
	printf("\n");
	printf("%d\n",index(p, pChild, 0));
	printf("%d",Index_KMP(p,pChild,0));
	system("pause");
}