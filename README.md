## Welcome to GitHub Pages
远程仓库重命名后同步本地提交
github上renanme（study--> jucstudy）后，
在本地项目git git remote -v 发现仍然是study。
git remote set-url origin git@github.com:tang-bf/jucstudy.git
再次查看，已经同步过来。
改完之后连接本地仓库和远程仓库，同步一下
$ git branch --set-upstream-to=origin/master
即可pull ,push。
刚开始我的github中没有添加SSH key，
去github中添加SSH Key”，填任意Title，
在Key文本框里粘贴id_rsa.pub文件的内容，解决。

