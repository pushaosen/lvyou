<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<form method="post" class="form-x" id="woSceneImportForm"
	enctype="multipart/form-data">
		
		<div class="form-group">
		<div class="label">
			<label for="importFile">
				景区数据</label>
		</div>
		<div class="field">
			<a class="button input-file" href="javascript:void(0);">+ 请选择导入文件
        <input size="100" name="importFile" id="importFile"  data-validate="required:请选择文件,regexp#.+.(xls|xlsx)$:只能上传xls|xlsx格式文件"
            type="file" />
    </a>
		</div>
	</div>
		
		<div class="form-button">
			<button class="button bg-main icon-save" type="button"
				onclick="Wobb.submitSceneImportForm();"> 保存</button>
			<button class="button bg-yellow icon-arrow-circle-right"
				type="button" onclick="WoKit.destroyMainFrame();"> 取消</button>
		</div>
	</form>
</div>