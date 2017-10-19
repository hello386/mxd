  
    var jsonArray = [];
    $(function() {
    	$('#tt').tree({
    	    url:base+'/service/userMgrSite',
    	    onClick: function(node){
    			//alert(node.text);  // alert node text property when clicked
    	    	var columUrl = base+'/service/getPageTreeNode?parentId='+node.parentId+"&siteId="+node.id;
    	    	$('#tt_coloum').tree({
    	    	    url:columUrl,
    	    	    onClick: function(node){
    	    			//alert(node.text);  // alert node text property when clicked
    	    	    	var url = base+'/article/getArticleByPage?columnId='+node.id+"&pageNo=1&pageSize=10";
    	    	    	$('#dg').datagrid({
    	    	    	    url:url
    	    	    	});
    	    			console.log(url);
    	    		}
    	    	});
    		}
    	});
    	
    	var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
		pager.pagination({
			buttons:[{
				iconCls:'icon-search',
				handler:function(){
					alert('search');
				}
			},{
				iconCls:'icon-add',
				handler:function(){
					alert('add');
				}
			},{
				iconCls:'icon-edit',
				handler:function(){
					alert('edit');
				}
			}]
		});			
    });