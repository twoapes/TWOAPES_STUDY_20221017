git config --global user.name "******" #提交所使用的的用户名
git config --global user.email "******@.com" #提交所使用的邮箱
#默认15分钟
git config --global credential.helper cache
#自定义时间
git config credential.helper 'cache --timeout=3600'
#永久存储(记住)密码
git config --global credential.helper store
#根据远程地址存储密码
http://用户名:密码@....git
#忽略文件名长度
git config --global core.longpaths true
#缩减pack
git gc --aggressive --prune=now
#本地废弃
git fetch --all
git reset --hard origin/master
git fetch
#当前仓库
git remote show origin

#码字数量
git log --author="用户名" --pretty=tformat: --numstat | awk '{ add += $1; subs += $2; loc += $1 - $2 } END { printf "added lines: %s, removed lines: %s, total lines: %s\n", add, subs, loc }' -

#恢复指定版本号
git log　 
git reset -- xxx
git push -f origin master