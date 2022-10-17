# 借助Spring表单绑定标签库中所包含的标签，我们能够将模型对象绑定到渲染后的HTML表单中

JSP标签|描述
--|--
&#60;sf&#58;checkbox&#62;|渲染成一个HTML&#60;input&#62;标签，其中type属性设置为checkbox
&#60;sf&#58;checkboxs&#62;|渲染成多个HTML&#60;input&#62;标签，其中type属性设置为checkbox
&#60;sf&#58;errors&#62;|在一个HTML&#60;span&#62;中输入输入域的错误
&#60;sf&#58;form&#62;|渲染成一个HTML &#60;form&#62;标签，并为其内部标签暴露绑定路径，用于数据绑定
&#60;sf&#58;hidden&#62;|渲染成一个HTML&#60;input&#62;标签，其中type属性设置为hidden
&#60;sf&#58;input&#62;|渲染成一个HTML&#60;input&#62;标签，其中type属性设置为text
&#60;sf&#58;label&#62;|渲染成一个HTML&#60;label&#62;标签
&#60;sf&#58;option&#62;|渲染成一个HTML&#60;option&#62;标签，其selected属性根据所绑定的执行设置
&#60;sf&#58;options&#62;|按照绑定的集合、数组或Map，渲染成一个HTML&#60;option&#62;标签列表
&#60;sf&#58;password&#62;|渲染成一个HTML&#60;input&#62;标签，其中type属性设置为password
&#60;sf&#58;radiobutton&#62;|渲染成一个HTML&#60;input&#62;标签，其中type属性设置为radio
&#60;sf&#58;radiobuttons&#62;|渲染成多个HTML&#60;input&#62;标签，其中type属性设置为radio
&#60;sf&#58;select&#62;|渲染为一个HTML&#60;select&#62;标签
&#60;sf&#58;textarea&#62;|渲染为一个HTML&#60;textarea&#62;标签
