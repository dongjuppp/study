# AWK

첫 번째 열이 알파벳이라면 그 줄 출력
``` script
 awk '$1 ~ /^[A-Z]+$/ {print $0}' text.txt
```

첫 번쨰 열이 알파벳이 아니라면 그 줄 출력 
``` script
 awk '$1 !~ /^[A-Z]+$/ {print $0}' text.txt
```

4번째 줄 제외하고 모두 출력
``` script
awk 'NR != 4 {print $0}' text.txt
```

