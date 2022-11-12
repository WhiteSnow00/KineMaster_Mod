attribute vec4 a_position;
attribute vec2 a_texCoord;
uniform highp mat4 u_mvp_matrix;
uniform highp vec2 u_texture_size;
varying highp vec2 v_v2TexCoord0;
varying highp vec2 v_blurTexCoords[14];
void main()
{
    highp vec2 conv_texture_size = floor(u_texture_size);
	v_v2TexCoord0 = a_texCoord;
	v_blurTexCoords[ 0] = v_v2TexCoord0 + vec2(0.0, -7.0 / conv_texture_size.y);
	v_blurTexCoords[ 1] = v_v2TexCoord0 + vec2(0.0, -6.0 / conv_texture_size.y);
	v_blurTexCoords[ 2] = v_v2TexCoord0 + vec2(0.0, -5.0 / conv_texture_size.y);
	v_blurTexCoords[ 3] = v_v2TexCoord0 + vec2(0.0, -4.0 / conv_texture_size.y);
	v_blurTexCoords[ 4] = v_v2TexCoord0 + vec2(0.0, -3.0 / conv_texture_size.y);
	v_blurTexCoords[ 5] = v_v2TexCoord0 + vec2(0.0, -2.0 / conv_texture_size.y);
	v_blurTexCoords[ 6] = v_v2TexCoord0 + vec2(0.0, -1.0 / conv_texture_size.y);
	v_blurTexCoords[ 7] = v_v2TexCoord0 + vec2(0.0,  1.0 / conv_texture_size.y);
	v_blurTexCoords[ 8] = v_v2TexCoord0 + vec2(0.0,  2.0 / conv_texture_size.y);
	v_blurTexCoords[ 9] = v_v2TexCoord0 + vec2(0.0,  3.0 / conv_texture_size.y);
	v_blurTexCoords[10] = v_v2TexCoord0 + vec2(0.0,  4.0 / conv_texture_size.y);
	v_blurTexCoords[11] = v_v2TexCoord0 + vec2(0.0,  5.0 / conv_texture_size.y);
	v_blurTexCoords[12] = v_v2TexCoord0 + vec2(0.0,  6.0 / conv_texture_size.y);
	v_blurTexCoords[13] = v_v2TexCoord0 + vec2(0.0,  7.0 / conv_texture_size.y);
	gl_Position = vec4(a_position.xyz, 1) * u_mvp_matrix;
}