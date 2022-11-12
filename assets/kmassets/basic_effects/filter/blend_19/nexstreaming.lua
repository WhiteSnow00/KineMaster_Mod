effect = {matrix = 0, left = -1, top = -1, right = 1, bottom = 1, alpha = 1}

function setDefaultValue()

    effect.matrix = 0
    effect.left = -1
    effect.top = -1
    effect.right = 1
    effect.bottom = 1
    effect.alpha = 1
end

function setMatrixRECT(matrix, left, top, right, bottom, alpha)

    effect.matrix = matrix
    effect.left = left
    effect.top = top
    effect.right = right
    effect.bottom = bottom
    effect.alpha = alpha
end