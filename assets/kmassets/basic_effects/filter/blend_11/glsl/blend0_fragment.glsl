precision highp float;
precision highp int;

uniform sampler2D u_sTexture0;
uniform sampler2D u_sTexture1;
uniform highp float u_alpha;
uniform highp mat4 u_color_matrix;
varying highp vec2 v_v2TexCoord;
varying highp vec2 v_v2TexCoordScreen;

float blendLighten(float base, float blend) {
	return max(blend,base);
}

vec3 blendLighten(vec3 base, vec3 blend) {
	return vec3(blendLighten(base.r,blend.r),blendLighten(base.g,blend.g),blendLighten(base.b,blend.b));
}

vec3 blendLighten(vec3 base, vec3 blend, float opacity) {
	return (blendLighten(base, blend) * opacity + base * (1.0 - opacity));
}

void main()
{
	highp vec4 col0 = texture2D(u_sTexture0,v_v2TexCoord);
    highp vec4 col1 = texture2D(u_sTexture1,vec2(v_v2TexCoordScreen.x, v_v2TexCoordScreen.y));
    highp vec4 color = col1.a<=0.0?vec4(1, 1, 1, 0):vec4(col1.rgb/col1.a, col1.a);
	color = color * u_color_matrix;

	color.rgb = blendLighten(col0.rgb, color.rgb, color.a);
	gl_FragColor =  vec4(color.rgb * u_alpha, u_alpha);
}