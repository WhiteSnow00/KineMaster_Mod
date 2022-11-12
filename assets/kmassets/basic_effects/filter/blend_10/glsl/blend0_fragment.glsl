precision highp float;
precision highp int;

uniform sampler2D u_sTexture0;
uniform sampler2D u_sTexture1;
uniform highp float u_alpha;
uniform highp mat4 u_color_matrix;
varying highp vec2 v_v2TexCoord;
varying highp vec2 v_v2TexCoordScreen;

float blendColorBurn(float base, float blend) {
	return (blend==0.0)?blend:max((1.0-((1.0-base)/blend)),0.0);
}

float blendColorDodge(float base, float blend) {
	return (blend==1.0)?blend:min(base/(1.0-blend),1.0);
}

float blendVividLight(float base, float blend) {
	return (blend<0.5)?blendColorBurn(base,(2.0*blend)):blendColorDodge(base,(2.0*(blend-0.5)));
}

float blendHardMix(float base, float blend) {
	return (blendVividLight(base,blend)<0.5)?0.0:1.0;
}

vec3 blendHardMix(vec3 base, vec3 blend) {
	return vec3(blendHardMix(base.r,blend.r),blendHardMix(base.g,blend.g),blendHardMix(base.b,blend.b));
}

vec3 blendHardMix(vec3 base, vec3 blend, float opacity) {
	return (blendHardMix(base, blend) * opacity + base * (1.0 - opacity));
}

void main()
{
	highp vec4 col0 = texture2D(u_sTexture0,v_v2TexCoord);
    highp vec4 col1 = texture2D(u_sTexture1,vec2(v_v2TexCoordScreen.x, v_v2TexCoordScreen.y));
    highp vec4 color = col1.a<=0.0?vec4(1, 1, 1, 0):vec4(col1.rgb/col1.a, col1.a);
	color = color * u_color_matrix;

	color.rgb = blendHardMix(col0.rgb, color.rgb, color.a);
	gl_FragColor =  vec4(color.rgb * u_alpha, u_alpha);
}