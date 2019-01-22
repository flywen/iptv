<%@ taglib prefix="valueField" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        var url;

        function deleteChannel() {
            var selectedRows = $("#dg").datagrid('getSelections');
            if (selectedRows.length == 0){
                $.messager.alert("系统提示","请选择要删除的数据");
                return;
            }
            var strIds = [];
            for (var i = 0; i < selectedRows.length; i++){
                strIds.push(selectedRows[i].id);
            }
            var ids = strIds.join(",");
            $.messager.confirm("系统提示","要删除这"+selectedRows.length+"条数据吗？",function(r){
                if (r){
                    $.post("${pageContext.request.contextPath}/channel/delete.do",{
                        ids: ids
                    },function (result) {
                        if (result.success) {
                            $.messager.alert("系统提示","数据删除成功");
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示","数据删除失败");
                        }
                    },"json");
                }
            });

        }

        function openChannelModifyDialog() {
            var selectdRows = $("#dg").datagrid('getSelections');
            if (selectdRows.length != 1) {
                $.messager.alert("系统提示","请选择一条要修改的数据");
                return;
            }
            var row = selectdRows[0];
            $("#dlg").dialog("open").dialog("setTitle","修改信息");
            $("#fm").form("load",row);
            url = "${pageContext.request.contextPath}/channel/save.do?id=" + row.id;
        }

        function openChannelAddDialog() {
            $("#dlg").dialog("open").dialog("setTitle","添加频道");
            url = "${pageContext.request.contextPath}/channel/save.do";
        }

        function saveChannel() {
            $("#fm").form("submit",{
                url:url,
                onSubmit:function (){
                    return $(this).form("validate");
                },
                success:function (result){
                    $.messager.alert("系统提示","保存成功！");
                    resetValue();
                    $("#dlg").dialog("close");
                    $("#dg").datagrid("reload");
                }
            });
        }

        function resetValue() {
            $("#className").val("");
            $("#desc").val("");
        }

        function closeChannelDialog() {
            $("#dlg").dialog("close");
            resetValue();
        }


    </script>

</head>
<body style="margin:1px;">
<table id="dg" title="频道管理" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/channel/list.do" fit="true"
       toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="10" align="center">编号</th>
        <th field="name" width="15" align="center">频道名称</th>
        <th field="in_url" width="30" align="center">输入地址</th>
        <th field="format" width="15" align="center">输入方式</th>
        <th field="out_url" width="30" align="center">输出地址</th>
        <th field="status" width="15" align="center">是否生效</th>
        <th field="className" width="20" align="center">所属分类</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openChannelAddDialog()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:openChannelModifyDialog()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:deleteChannel()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        &nbsp;分类名：&nbsp;<input type="text" id="s_userName" size="20"
                               onkeydown="if(event.keyCode==13) searchUser()"/> <a
            href="javascript:searchUser()" class="easyui-linkbutton"
            iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog"
     style="width: 800px;height:250px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>频道名称：</td>
                <td><input type="text" id="name" name="name"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font>
                </td>
                <td>所属分类：</td>
                <td>
                    <input type="text" id="class_id" class="easyui-combobox" name="class_id"
                           data-options="valueField:'id',textField:'className',url:'${pageContext.request.contextPath}/channelclass/listtosel.do',prompt:'所属分类'"/>
                </td>
                <td>是否生效：</td>
                <td>
                    <select class="easyui-combobox" id="status" name="status">
                        <option value="1">生效</option>
                        <option value="0">不生效</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>输入地址：</td>
                <td colspan="5"><input type="text" id="in_url" name="in_url"
                           class="easyui-validatebox" required="true" style="width: 595px"/>&nbsp;<font
                        color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>输出地址：</td>
                <td colspan="5"><input type="text" id="out_url" name="out_url"
                           class="easyui-validatebox" required="true" style="width: 595px"/>&nbsp;<font
                        color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>输入方式：</td>
                <td>
                    <select class="easyui-combobox" id="format" name="format">
                        <option value="rtp">RTP(组播)</option>
                        <option value="http">HTTP(点播)</option>
                    </select>
                </td>
                <td>编码格式：</td>
                <td>
                    <select class="easyui-combobox" id="codec" name="codec">
                        <option value="mepgts">mpegts</option>
                        <option value="h264">h.264</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveChannel()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a href="javascript:closeChannelDialog()"
                                   class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>