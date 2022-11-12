varying highp vec2 v_v2TexCoord0;
varying highp vec2 v_blurTexCoords[14];
uniform sampler2D u_sTexture0;

void main(){
	highp vec4 color;
	color.bgra = texture2D(u_sTexture0, v_v2TexCoord0) * 0.159576912161;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[0])*0.0044299121055113265;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[1])*0.00895781211794;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[2])*0.0215963866053;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[3])*0.0443683338718;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[4])*0.0776744219933;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[5])*0.115876621105;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[6])*0.147308056121;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[7])*0.147308056121;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[8])*0.115876621105;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[9])*0.0776744219933;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[10])*0.0443683338718;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[11])*0.0215963866053;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[12])*0.00895781211794;
	color.bgra += texture2D(u_sTexture0, v_blurTexCoords[13])*0.0044299121055113265;
	gl_FragColor = color.bgra;
}